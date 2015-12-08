package io.pivotal.data.eventservice.model;

/**
 * Created by cq on 17/9/15.
 */
public class EventQuality {

    private float goodEvents;

    private float badEvents;

    public float getGoodEvents() {
        return goodEvents;
    }

    public void setGoodEvents(float goodEvents) {
        this.goodEvents = goodEvents;
    }

    public float getBadEvents() {
        return badEvents;
    }

    public void setBadEvents(float badEvents) {
        this.badEvents = badEvents;
    }
}
