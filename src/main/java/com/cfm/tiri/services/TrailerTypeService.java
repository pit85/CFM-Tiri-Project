
package com.cfm.tiri.services;

import com.cfm.tiri.domain.TrailerType;

public interface TrailerTypeService {

	Iterable<TrailerType> listAllTrailerTypes();

	TrailerType getTrailerTypeById(Integer id);

	TrailerType saveTrailerType(TrailerType trailerType);

}
