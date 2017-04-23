package com.cfm.tiri.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cfm.tiri.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Iterable<User> findByActive(Boolean active);
	// Zgodnie z
	// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
	
	@Query(value = "SELECT * FROM TIRI_USER u LEFT JOIN (SELECT * FROM SQUAD where active = 1 AND ID_SQUAD not in (:squadId)) s on s.id_user=u.id_user WHERE u.ACTIVE = 1 and u.id_role=3 and s.id_trailer is null", nativeQuery = true)
	Iterable<User> findActiveAndFreeDrivers(@Param("squadId") int squadId);
	
}
