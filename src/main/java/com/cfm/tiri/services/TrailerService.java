package com.cfm.tiri.services;

import com.cfm.tiri.domain.Trailer;

public interface TrailerService {

	Iterable<Trailer> listAllTrailers();

	Trailer getTrailerById(long id);

	Trailer saveTrailer(Trailer trailer);
	
	Iterable<Trailer> listActiveTrailers(boolean active);

	Iterable<Trailer> listActiveAndFreeTrailers(long squadId);

}
