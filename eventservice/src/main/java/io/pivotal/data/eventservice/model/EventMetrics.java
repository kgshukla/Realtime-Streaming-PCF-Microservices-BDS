package io.pivotal.data.eventservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cq on 17/9/15.
 */
@Region("ProcessData")
public class EventMetrics implements Serializable{


    @Id
    private String key;

    private List<String> data;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
