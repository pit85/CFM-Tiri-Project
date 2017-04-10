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
	public Truck getTruckById(Integer id) {
		return truckRepository.findOne(id);
	}

	@Override
	public Truck saveTruck(Truck truck) {
		return truckRepository.save(truck);
	}

	@Override
	public Iterable<Truck> listActiveTrucks(Boolean active) {
		return truckRepository.findByActive(active);
	}

}