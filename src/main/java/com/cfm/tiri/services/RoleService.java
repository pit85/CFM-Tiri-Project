package com.cfm.tiri.services;

import com.cfm.tiri.domain.Role;

public interface RoleService {

	Iterable<Role> listAllRoles();

	Role getRoleById(long id);

	Role saveRole(Role role);

}
