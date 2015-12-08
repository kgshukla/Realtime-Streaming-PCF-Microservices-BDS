package io.pivotal.data.eventservice.repositories;

import io.pivotal.data.eventservice.model.EventMetrics;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by cq on 17/9/15.
 */
public interface EventsRepository extends CrudRepository<EventMetrics,String> {


}
