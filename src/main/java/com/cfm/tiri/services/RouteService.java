package com.cfm.tiri.services;

import java.util.List;

import com.cfm.tiri.domain.Route;
import com.cfm.tiri.mapping.RouteReport;
import com.cfm.tiri.mapping.RouteDetailedReport;
import com.cfm.tiri.domain.RouteStatus;


public interface RouteService {
	
	Iterable<Route> listAllRoutes();

	Iterable<Route> listAllRoutesOrderByRouteDateDesc();
	
	Iterable<Route> listAllRefuelings();
	
	Iterable<Route> listAllRoutesOrderByRouteDateDesc(String registrationNumber);
	
	List<RouteReport> listFuelConsumption(String startDate, String endDate);
	
	List<RouteDetailedReport> listDetailedFuelConsumption(String startDate, String endDate);
	
	Iterable<RouteStatus> listRouteStatuses();
	
	Route getRouteById(long id);

	Route saveRoute(Route route);
	
	void deleteRoute(long id);
	

}
