package com.cfm.tiri.services;

import java.util.List;

import com.cfm.tiri.jpa.Role;

 
public interface RoleService extends CRUDService<Role> {
	
	List<?> listAll();

	
	
}