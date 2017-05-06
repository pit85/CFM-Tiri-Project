package com.cfm.tiri.services;

import com.cfm.tiri.domain.Route;

public interface RouteService {
	
	Iterable<Route> listAllRoutes();

	Iterable<Route> listAllRoutesOrderByRouteDateDesc();
	
	Route getRouteById(long id);

	Route saveRoute(Route route);
	
	Iterable<Route> listAllRefuelings();
	
	void deleteRoute(long id);
	

}
