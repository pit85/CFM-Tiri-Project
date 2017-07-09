package com.cfm.tiri.services;

import com.cfm.tiri.domain.Truck;
import com.cfm.tiri.repositories.TruckRepository;;

public interface TruckService {
	
	void setTruckRepository(TruckRepository truckRepository);

	Iterable<Truck> findAll();
	
	Truck findById(long id);

	Truck save(Truck truck);

	Iterable<Truck> findByActive(boolean active);
	
	Iterable<Truck> findActiveAndFree(long squadId);
	
	
}
