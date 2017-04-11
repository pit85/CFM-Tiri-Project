package com.cfm.tiri.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.tiri.domain.Trailer;
import com.cfm.tiri.repositories.TrailerRepository;

@Service
public class TrailerServiceImpl implements TrailerService{
	private TrailerRepository trailerRepository;
	
	@Autowired
	public void setTrailerRepository(TrailerRepository trailerRepository) {
		this.trailerRepository = trailerRepository;
	}

	@Override
	public Iterable<Trailer> listAllTrailers() {
		return this.trailerRepository.findAll();
	}

	@Override
	public Trailer getTrailerById(Integer id) {
		return trailerRepository.findOne(id);
	}

	@Override
	public Trailer saveTrailer(Trailer trailer) {
		return trailerRepository.save(trailer);
	}

	@Override
	public Iterable<Trailer> listActiveTrailers(Boolean active) {
		return trailerRepository.findByActive(active);
	}

}
