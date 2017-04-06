package com.cfm.tiri.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cfm.tiri.jpa.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
