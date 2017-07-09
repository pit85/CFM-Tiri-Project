package com.cfm.tiri.services;

import com.cfm.tiri.domain.Truck;
import com.cfm.tiri.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckServiceImpl implements TruckService {
	
	private TruckRepository truckRepository;
	
	@Autowired
	public void setTruckRepository(TruckRepository truckRepository) {
		this.truckRepository = truckRepository;
	}

	@Override
	public Iterable<Truck> findAll() {
		return truckRepository.findAll();
	}

	@Override
	public Truck findById(long id) {
		return truckRepository.findById(id);
	}

	@Override
	public Truck save(Truck truck) {
		return truckRepository.save(truck);
	}

	@Override
	public Iterable<Truck> findByActive(boolean active) {
		return truckRepository.findByActive(active);
	}

	@Override
	public Iterable<Truck> findActiveAndFree(long squadId) {
		return truckRepository.findActiveAndFree(squadId);
	}

}