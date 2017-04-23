package com.cfm.tiri.services;

import com.cfm.tiri.domain.Truck;;

public interface TruckService {

	Iterable<Truck> listAllTrucks();

	Truck getTruckById(Integer id);

	Truck saveTruck(Truck truck);

	Iterable<Truck> listActiveTrucks(Boolean active);
	
	Iterable<Truck> listActiveAndFreeTrucks(int squadId);
	
	
}
