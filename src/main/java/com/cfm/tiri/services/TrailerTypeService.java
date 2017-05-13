
package com.cfm.tiri.services;

import com.cfm.tiri.domain.TrailerType;

public interface TrailerTypeService {

	Iterable<TrailerType> listAllTrailerTypes();

	TrailerType getTrailerTypeById(long id);

	TrailerType saveTrailerType(TrailerType trailerType);

}
