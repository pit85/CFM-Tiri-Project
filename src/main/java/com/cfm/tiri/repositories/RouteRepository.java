package com.cfm.tiri.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cfm.tiri.domain.Route;



@Repository
public interface RouteRepository extends CrudRepository<Route, Long>{
	
	
	@Query(value = "SELECT * FROM route WHERE id_route_status=1", nativeQuery = true)
	Iterable<Route> findRefuelings();

	Iterable<Route> findAllByOrderByRouteDateDesc();
	
	
	@Query(value = "SELECT r.* FROM tiridb.route r LEFT JOIN tiridb.squad s ON s.id_squad = r.id_squad LEFT JOIN tiridb.truck t ON t.id_truck = s.id_truck WHERE t.registration_number = :registrationnumber ORDER BY route_date DESC", nativeQuery = true)
	Iterable<Route> findAllByOrderByRouteDateDesc(@Param("registrationnumber") String registrationNumber);

	
}
