package com.cfm.tiri.services;

import com.cfm.tiri.jpa.User;

public interface UserService {

	Iterable<User> listAllUsers();

	User getUserById(Integer id);

	User saveUser(User trailer);

	Iterable<User> listActiveUsers(Boolean active);

}
