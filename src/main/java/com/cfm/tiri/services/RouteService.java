package com.cfm.tiri.services;

import com.cfm.tiri.domain.Route;
import com.cfm.tiri.domain.RouteReport;


public interface RouteService {
	
	Iterable<Route> listAllRoutes();

	Iterable<Route> listAllRoutesOrderByRouteDateDesc();
	
	Iterable<Route> listAllRefuelings();
	
	Iterable<Route> listAllRoutesOrderByRouteDateDesc(String registrationNumber);
	
	
	Iterable<RouteReport> listAverageFuelConsumption(String startDate, String endDate);
	
	
	
	Route getRouteById(long id);

	Route saveRoute(Route route);
	
	void deleteRoute(long id);
	

}
