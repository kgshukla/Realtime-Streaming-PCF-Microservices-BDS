package io.pivotal.data.taxiservice.repositories;

import io.pivotal.data.taxiservice.models.TaxiRouteMetrics;

import org.springframework.data.repository.CrudRepository;

public interface TaxiRouteRepository extends
		CrudRepository<TaxiRouteMetrics, String> {

}
