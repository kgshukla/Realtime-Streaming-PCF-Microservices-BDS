<?php 

$vcap_services2 =  $_ENV["VCAP_SERVICES"];
$aggservice_url=json_decode($vcap_services2)->{'user-provided'}[0]->{'credentials'}->{'AGGSERVICE_URL'};

$table = array();

if (isset($_POST["type"])) {
    if ($_POST["type"] == "INCORRECT_DATA") {
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $aggservice_url."/top10erringdrivers");
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        $output = curl_exec($ch);
        curl_close($ch);

        $table['cols'] = array(
            array('id' => "", 'label' => 'Taxi ID', 'pattern' => "", 'type' => 'string'),
            array('id' => "", 'label' => '# Counts', 'pattern' => "", 'type' => 'number')
        );
        $rows = array(); 
        foreach(json_decode($output) as $nt) {
            $temp = array();
            $temp[] = array('v' => $nt->drivernum, 'f' =>NULL);
            $temp[] = array('v' => $nt->numoferrors, 'f' =>NULL);
            $rows[] = array('c' => $temp);
        }

        $table['rows'] = $rows;
        $jsonTable = json_encode($table);
        echo $jsonTable;
    } else if ($_POST["type"] == "TOPTAXID_FARE") {
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $aggservice_url."/top10earningdrivers");
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        $output = curl_exec($ch);
        curl_close($ch);

        $table = array();
        $table['cols'] = array(
            array('id' => "", 'label' => 'Taxi Driver', 'pattern' => "", 'type' => 'string'),
            array('id' => "", 'label' => '# Fare', 'pattern' => "", 'type' => 'number')
        );
        $rows = array(); 
        foreach(json_decode($output) as $nt) {
            $temp = array();
            $temp[] = array('v' => $nt->drivernum, 'f' =>NULL);
            $temp[] = array('v' => $nt->earnedrev, 'f' =>NULL);
            $rows[] = array('c' => $temp);
        }

        $table['rows'] = $rows;
        $jsonTable = json_encode($table);
        echo $jsonTable;
    }
}
?>
