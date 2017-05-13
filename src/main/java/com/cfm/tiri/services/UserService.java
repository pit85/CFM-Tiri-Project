package com.cfm.tiri.services;

import com.cfm.tiri.domain.User;

public interface UserService {

	Iterable<User> listAllUsers();

	User getUserById(long id);

	User saveUser(User trailer);

	Iterable<User> listActiveUsers(boolean active);
	
	Iterable<User> listActiveAndFreeDrivers(long squadId);

}
