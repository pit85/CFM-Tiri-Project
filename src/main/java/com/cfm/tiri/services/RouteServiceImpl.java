package com.cfm.tiri.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cfm.tiri.domain.Route;
import com.cfm.tiri.mapping.RouteReport;
import com.cfm.tiri.domain.RouteStatus;
import com.cfm.tiri.repositories.RouteRepository;
import com.cfm.tiri.repositories.RouteStatusRepository;

@Service
public class RouteServiceImpl implements RouteService{
	
    @PersistenceContext
    private EntityManager em;
	
	private RouteRepository routeRepository;

	private RouteStatusRepository routeStatusRepository;
	
	@Autowired
	public void setRouteRepository(RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}
	
	
	@Autowired
	public void setRouteStatusRepository(RouteStatusRepository routeStatusRepository) {
		this.routeStatusRepository = routeStatusRepository;
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
	

	@SuppressWarnings("unchecked")
	@Override
	public List<RouteReport> listAverageFuelConsumption(String startDate, String endDate) {
	
//		Mapping named query to POJO object. Query is located in Route Entity
		Query query = em.createNamedQuery("FuelConsumptionReport");
		query.setParameter(1, endDate);
		query.setParameter(2, startDate);
		List<RouteReport> report = query.getResultList();
		return report;
		
	}

	@Override
	public Iterable<RouteStatus> listRouteStatuses() {
		return routeStatusRepository.findAll();
	}

}
