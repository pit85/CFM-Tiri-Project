package com.cfm.tiri.services;

import java.util.List;

import com.cfm.tiri.jpa.Role;

 
public interface RoleService extends CRUDService<Role> {
	
	List<Role> listAll();

	Role getById(Integer id);

	Role saveOrUpdate(Role role);
	
	
}