package com.cfm.tiri.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cfm.tiri.domain.Route;


@Repository
public interface RouteRepository extends CrudRepository<Route, Long>{
	
	
	@Query(value = "SELECT * FROM route WHERE id_route_status=1", nativeQuery = true)
	Iterable<Route> findRefuelings();

	Iterable<Route> findAllByOrderByRouteDateDesc();

}
