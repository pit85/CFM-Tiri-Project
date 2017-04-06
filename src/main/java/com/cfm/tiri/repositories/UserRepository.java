package com.cfm.tiri.repositories;

import com.cfm.tiri.jpa.User;
import org.springframework.data.repository.CrudRepository;
 
public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String username);
}