package io.pivotal.data.eventservice.services;

import io.pivotal.data.eventservice.model.EventQuality;
import io.pivotal.data.eventservice.repositories.EventsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cq on 17/9/15.
 */
@Component
public class EventsService {

    @Autowired
    EventsRepository eventsRepository;

    public long totalOfEvents(){

        List<String> eventData = (List<String>) eventsRepository.findOne("LATEST_DATA");
        long totalEvents = Long.valueOf(eventData.get(0));
        return totalEvents;
    }

    public long totalMissedEvents(){
        List<String> eventData = (List<String>) eventsRepository.findOne("LATEST_DATA");
        long missedEvents = Long.valueOf(eventData.get(1));
        return missedEvents;
    }

    public long totalCorrectEvents(){
        List<String> eventData = (List<String>) eventsRepository.findOne("LATEST_DATA");
        long totalEvents = Long.valueOf(eventData.get(0));
        long missedEvents = Long.valueOf(eventData.get(1));
        return (totalEvents-missedEvents);
    }
    
    public EventQuality eventsQuality(){
        List<String> eventData = (List<String>) eventsRepository.findOne("LATEST_DATA");
        long totalEvents = Long.valueOf(eventData.get(0));
        long missedEvents = Long.valueOf(eventData.get(1));

        EventQuality eventQuality = new EventQuality();
        float goodEvents = ((totalEvents - missedEvents)/totalEvents);
        float badEvents = (missedEvents/totalEvents);

        eventQuality.setBadEvents(badEvents);
        eventQuality.setGoodEvents(goodEvents);
        return eventQuality;


    }

    /**
     * Gets the latest window processing time
     * @return
     */
    public int latestWPT(){
        List<String> eventData = (List<String>) eventsRepository.findOne("LATEST_DATA");
        int wpt = Integer.valueOf(eventData.get(2));
        return wpt;
    }


}
