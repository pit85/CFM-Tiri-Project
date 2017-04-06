package com.cfm.tiri.services;

import java.util.List;


import com.cfm.tiri.jpa.User;
 
public interface UserService extends CRUDService<User> {
 
    User findByUsername(String username);
    
	List<?> listAll();

	User getById(Integer id);

	User saveOrUpdate(User role);
 
}