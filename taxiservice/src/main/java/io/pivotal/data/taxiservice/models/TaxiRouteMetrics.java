/**
 * 
 */
package io.pivotal.data.taxiservice.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

/**
 * @author shuklk2
 *
 */

@Region("TaxiData")
public class TaxiRouteMetrics implements Serializable {

	@Id
	private String key;
	
	private List<RouteData> data;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<RouteData> getData() {
        return data;
    }

    public void setData(List<RouteData> data) {
        this.data = data;
    }
	
}
