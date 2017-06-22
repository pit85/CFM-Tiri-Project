
package com.cfm.tiri.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.tiri.domain.TrailerType;
import com.cfm.tiri.repositories.TrailerTypeRepository;

@Service
public class TrailerTypeServiceImpl implements TrailerTypeService{
	private TrailerTypeRepository trailerTypeRepository;
	
	@Autowired
	public void setTrailerTypeRepository(TrailerTypeRepository trailerTypeRepository) {
		this.trailerTypeRepository = trailerTypeRepository;
	}

	@Override
	public Iterable<TrailerType> listAllTrailerTypes() {
		return trailerTypeRepository.findAll();
	}

	@Override
	public TrailerType getTrailerTypeById(long id) {
		return trailerTypeRepository.findOne(id);
	}

	@Override
	public TrailerType saveTrailerType(TrailerType trailerType) {
		return trailerTypeRepository.save(trailerType);
	}

}
