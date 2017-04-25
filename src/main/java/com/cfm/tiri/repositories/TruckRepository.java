package com.cfm.tiri.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cfm.tiri.domain.Truck;

public interface TruckRepository extends CrudRepository<Truck, Integer> {

	Iterable<Truck> findByActive(boolean active);
	// Zgodnie z
	// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
	
	//aktywne oraz nie przynalezace do zadnego aktywnego skladu ciezarowki 
	@Query(value = "SELECT * FROM truck t LEFT JOIN (SELECT * FROM squad where active = 1 AND id_squad not in (:squadId)) s on s.id_truck=t.id_truck WHERE t.active = 1 and s.id_truck is null", nativeQuery = true)
	Iterable<Truck> findActiveAndFree(@Param("squadId") int squadId);
	

}