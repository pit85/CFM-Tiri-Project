package com.cfm.tiri.services;

import com.cfm.tiri.domain.Route;
import com.cfm.tiri.domain.RouteStatus;
import com.cfm.tiri.pojo.RouteDetailedReport;
import com.cfm.tiri.pojo.RouteReport;


public interface RouteService {
	
	Iterable<Route> listAllRoutes();

	Iterable<Route> listAllRoutesOrderByRouteDateDesc();
	
	Iterable<Route> listAllRefuelings();
	
	Iterable<Route> listAllRoutesOrderByRouteDateDesc(String registrationNumber);
	
	Iterable<RouteReport> listFuelConsumption(String startDate, String endDate);
	
	Iterable<RouteDetailedReport> listDetailedFuelConsumption(String startDate, String endDate);
	
	Iterable<RouteStatus> listRouteStatuses();
	
	Route getRouteById(long id);

	Route saveRoute(Route route);
	
	void deleteRoute(long id);
	

}
