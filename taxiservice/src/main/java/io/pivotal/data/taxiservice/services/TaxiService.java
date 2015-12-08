/**
 * 
 */
package io.pivotal.data.taxiservice.services;

import java.util.ArrayList;
import java.util.List;

import io.pivotal.data.taxiservice.models.RouteData;
import io.pivotal.data.taxiservice.repositories.TaxiRouteRepository;
import io.pivotal.data.taxiservice.repositories.FreeTaxiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shuklk2
 *
 */
@Component
public class TaxiService {

	@Autowired
	private TaxiRouteRepository repository;
	
	@Autowired
	private FreeTaxiRepository freetaxirepository;
	
	public List<RouteData> getTop10Routes() {
		List<RouteData> top10routes = (List<RouteData>) repository.findOne("LATEST_DATA");
		return top10routes;
	}
	
    public List<List<String>> getFreeTaxiesList() {
		Object data =  freetaxirepository.findOne("LATEST_DATA");
		return (List<List<String>>)data;
	}

}
