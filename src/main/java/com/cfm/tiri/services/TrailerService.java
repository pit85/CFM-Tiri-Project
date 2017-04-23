package com.cfm.tiri.services;

import com.cfm.tiri.domain.Trailer;

public interface TrailerService {

	Iterable<Trailer> listAllTrailers();

	Trailer getTrailerById(Integer id);

	Trailer saveTrailer(Trailer trailer);
	
	Iterable<Trailer> listActiveTrailers(Boolean active);

	Iterable<Trailer> listActiveAndFreeTrailers(int squadId);

}
