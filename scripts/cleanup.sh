
cf d aggservice-iot -f
cf d analyticservice-iot -f
cf d eventservice-iot -f
cf d iot-taxi -f 
cf d taxiservice-iot -f

cf ds agg_service_iot -f
cf ds config-server -f
cf ds service-registry -f
cf ds circuit-breaker -f 

cf delete-orphaned-routes -f 
