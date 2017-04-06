package com.cfm.tiri.services;

import com.cfm.tiri.jpa.User;
 
public interface UserService extends CRUDService<User> {
 
    User findByUsername(String username);
 
}