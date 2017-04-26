package com.cfm.tiri.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cfm.tiri.domain.Squad;

public interface SquadRepository extends CrudRepository<Squad, Long>{

	Iterable<Squad> findByActive(boolean active);
}
