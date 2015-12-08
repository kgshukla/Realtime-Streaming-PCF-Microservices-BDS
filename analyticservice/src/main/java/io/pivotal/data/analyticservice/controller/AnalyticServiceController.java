/**
 * 
 */
package io.pivotal.data.analyticservice.controller;

import java.util.List;

import io.pivotal.data.analyticservice.models.DriverIncorrectData;
import io.pivotal.data.analyticservice.models.DriverRevenueData;
import io.pivotal.data.analyticservice.services.AnalyticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuklk2
 *
 */
@RestController
public class AnalyticServiceController {

	@Autowired
	private AnalyticService service;
	
	@RequestMapping(value = "/analytics/top10erringdrivers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DriverIncorrectData> getTop10IncorrectDriverList() {
		return service.getTop10IncorrectDriverData();
	}
	
	@RequestMapping(value = "/analytics/top10earningdrivers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DriverRevenueData> getTop10EarningDriverList() {
		return service.getTop10EarningDrivers();
	}
}
