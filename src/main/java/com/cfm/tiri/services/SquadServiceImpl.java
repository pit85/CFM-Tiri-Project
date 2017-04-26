package com.cfm.tiri.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.tiri.domain.Squad;
import com.cfm.tiri.repositories.SquadRepository;

@Service
public class SquadServiceImpl implements SquadService{
	private SquadRepository squadRepository;
	
	@Autowired
	public void setSquadRepository(SquadRepository squadRepository) {
		this.squadRepository = squadRepository;
	}

	@Override
	public Iterable<Squad> listAllSquads() {
		return this.squadRepository.findAll();
	}

	@Override
	public Squad getSquadById(long id) {
		return squadRepository.findOne(id);
	}

	@Override
	public Squad saveSquad(Squad squad) {
		return squadRepository.save(squad);
	}

	@Override
	public Iterable<Squad> listActiveSquads(boolean active) {
		return squadRepository.findByActive(active);
	}



}
