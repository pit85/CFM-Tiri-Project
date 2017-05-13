package com.cfm.tiri.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cfm.tiri.domain.RouteStatus;

@Repository
public interface RouteStatusRepository extends CrudRepository<RouteStatus, Long>{
}