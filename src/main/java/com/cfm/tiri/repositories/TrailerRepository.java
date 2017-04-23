package com.cfm.tiri.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cfm.tiri.domain.Trailer;

public interface TrailerRepository extends CrudRepository<Trailer, Integer> {

	Iterable<Trailer> findByActive(Boolean active);
	// Zgodnie z
	// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

	@Query(value = "SELECT * FROM TRAILER t LEFT JOIN (SELECT * FROM SQUAD where active = 1 AND ID_SQUAD not in (:squadId)) s on s.id_trailer=t.id_trailer WHERE t.ACTIVE = 1 and s.id_trailer is null", nativeQuery = true)
	Iterable<Trailer> findActiveAndFree(@Param("squadId") int squadId);
}
