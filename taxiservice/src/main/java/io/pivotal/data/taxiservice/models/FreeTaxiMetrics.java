package io.pivotal.data.taxiservice.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

/**
 * @author shuklk2
 *
 */

@Region("FreeTaxiList")
public class FreeTaxiMetrics implements Serializable{

	@Id
    private String key;

	private List<List<String>> data;
	
	public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
    
}
