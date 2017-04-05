package com.cfm.tiri.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cfm.tiri.jpa.TrailerType;

@Repository
public interface TrailerTypeRepository extends CrudRepository<TrailerType, Integer>{
}