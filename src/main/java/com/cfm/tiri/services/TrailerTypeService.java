
package com.cfm.tiri.services;

import com.cfm.tiri.jpa.TrailerType;

public interface TrailerTypeService {

	Iterable<TrailerType> listAllTrailerTypes();

	TrailerType getTrailerTypeById(Integer id);

	TrailerType saveTrailerType(TrailerType trailerType);

}
