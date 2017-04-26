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
	public Iterable<Truck> listAllTrucks() {
		return truckRepository.findAll();
	}

	@Override
	public Truck getTruckById(long id) {
		return truckRepository.findOne(id);
	}

	@Override
	public Truck saveTruck(Truck truck) {
		return truckRepository.save(truck);
	}

	@Override
	public Iterable<Truck> listActiveTrucks(boolean active) {
		return truckRepository.findByActive(active);
	}

	@Override
	public Iterable<Truck> listActiveAndFreeTrucks(long squadId) {
		return truckRepository.findActiveAndFree(squadId);
	}

}