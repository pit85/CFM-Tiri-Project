package com.cfm.tiri.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cfm.tiri.jpa.Trailer;

public interface TrailerRepository extends CrudRepository<Trailer, Integer> {

	Iterable<Trailer> findByActive(Boolean active);
	// Zgodnie z
	// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

}
