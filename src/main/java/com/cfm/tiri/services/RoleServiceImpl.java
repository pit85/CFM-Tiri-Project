package com.cfm.tiri.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.tiri.domain.Role;
import com.cfm.tiri.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	private RoleRepository roleRepository;
	
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Iterable<Role> listAllRoles() {
		return this.roleRepository.findAll();
	}

	@Override
	public Role getRoleById(long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

}