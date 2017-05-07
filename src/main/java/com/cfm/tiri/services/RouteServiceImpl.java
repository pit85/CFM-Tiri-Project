package com.cfm.tiri.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cfm.tiri.domain.Route;
import com.cfm.tiri.domain.RouteReport;
import com.cfm.tiri.repositories.RouteReportRepository;
import com.cfm.tiri.repositories.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService{
	
	private RouteRepository routeRepository;
	private RouteReportRepository routeReportRepository;
	
	@Autowired
	public void setRouteRepository(RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}
	

	@Autowired
	public void setRouteReportRepository(RouteReportRepository routeReportRepository) {
		this.routeReportRepository = routeReportRepository;
	}
	
	@Override
	public Iterable<Route> listAllRoutes() {
		return this.routeRepository.findAll();
	}
	
	
	@Override
	public Iterable<Route> listAllRoutesOrderByRouteDateDesc() {
		return this.routeRepository.findAllByOrderByRouteDateDesc();
	}
	

	@Override
	public Route getRouteById(long id) {
		return routeRepository.findOne(id);
	}

	@Override
	public Route saveRoute(Route route) {
		return routeRepository.save(route);
	}
	
	@Override
	public void deleteRoute(long id) {
		routeRepository.delete(id);
	}

	@Override
	public Iterable<Route> listAllRefuelings() {
		return routeRepository.findRefuelings();
	}

	@Override
	public Iterable<Route> listAllRoutesOrderByRouteDateDesc(String registrationNumber) {
		return routeRepository.findAllByOrderByRouteDateDesc(registrationNumber);
	}

	
	@Override
	public Iterable<RouteReport> listAverageFuelConsumption(String startDate, String endDate) {
		return routeReportRepository.generateFuelConsuptionReport(startDate, endDate);
	}

}
