package com.cfm.tiri.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cfm.tiri.domain.Squad;

@Repository
public interface SquadRepository extends CrudRepository<Squad, Long>{

	Iterable<Squad> findByActive(boolean active);
}
