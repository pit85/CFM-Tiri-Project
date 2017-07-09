package com.cfm.tiri.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cfm.tiri.domain.Trailer;

@Repository
public interface TrailerRepository extends CrudRepository<Trailer, Long> {

	Iterable<Trailer> findByActive(boolean active);
	
	Trailer findByRegistrationNumber(String registrationNumber);
	
	// Zgodnie z
	// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

	@Query(value = "SELECT * FROM trailer t LEFT JOIN (SELECT * FROM squad where active = 1 AND id_squad not in (:squadId)) s on s.id_trailer=t.id_trailer WHERE t.active = 1 and s.id_trailer is null", nativeQuery = true)
	Iterable<Trailer> findActiveAndFree(@Param("squadId") long squadId);
}
