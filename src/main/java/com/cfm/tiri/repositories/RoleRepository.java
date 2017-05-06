package com.cfm.tiri.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cfm.tiri.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
