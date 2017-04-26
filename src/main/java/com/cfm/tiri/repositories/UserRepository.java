package com.cfm.tiri.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cfm.tiri.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Iterable<User> findByActive(boolean active);
	// Zgodnie z
	// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
	
	@Query(value = "SELECT * FROM tiri_user u LEFT JOIN (SELECT * FROM squad where active = 1 AND id_squad not in (:squadId)) s on s.id_user=u.id_user WHERE u.active = 1 and u.id_role=3 and s.id_trailer is null", nativeQuery = true)
	Iterable<User> findActiveAndFreeDrivers(@Param("squadId") long squadId);
	
}
