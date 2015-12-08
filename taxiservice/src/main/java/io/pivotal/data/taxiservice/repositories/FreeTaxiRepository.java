package io.pivotal.data.taxiservice.repositories;

import io.pivotal.data.taxiservice.models.FreeTaxiMetrics;

import org.springframework.data.repository.CrudRepository;

public interface FreeTaxiRepository extends
		CrudRepository<FreeTaxiMetrics, String> {

}
