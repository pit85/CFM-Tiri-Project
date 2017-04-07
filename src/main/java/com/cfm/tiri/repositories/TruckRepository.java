package com.cfm.tiri.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cfm.tiri.jpa.Truck;

public interface TruckRepository extends CrudRepository<Truck, Integer> {

	Iterable<Truck> findByActive(Boolean active);
	// Zgodnie z
	// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

}