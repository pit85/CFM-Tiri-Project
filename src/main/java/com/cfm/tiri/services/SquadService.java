package com.cfm.tiri.services;

import com.cfm.tiri.domain.Squad;

public interface SquadService {

	Iterable<Squad> listAllSquads();

	Squad getSquadById(long id);

	Squad saveSquad(Squad squad);
	
	Iterable<Squad> listActiveSquads(boolean active);
	

}
