package com.cfm.tiri.services;

import com.cfm.tiri.domain.Truck;;

public interface TruckService {

	Iterable<Truck> listAllTrucks();

	Truck getTruckById(long id);

	Truck saveTruck(Truck truck);

	Iterable<Truck> listActiveTrucks(boolean active);
	
	Iterable<Truck> listActiveAndFreeTrucks(long squadId);
	
	
}
