package com.cfm.tiri.services;

import com.cfm.tiri.domain.Role;

public interface RoleService {

	Iterable<Role> listAllRoles();

	Role getRoleById(Integer id);

	Role saveRole(Role role);

}
