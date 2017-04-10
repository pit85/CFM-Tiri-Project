package com.cfm.tiri.services;

import com.cfm.tiri.domain.Squad;

public interface SquadService {

	Iterable<Squad> listAllSquads();

	Squad getSquadById(Integer id);

	Squad saveSquad(Squad trailer);
	
	Iterable<Squad> listActiveSquads(Boolean active);

}
