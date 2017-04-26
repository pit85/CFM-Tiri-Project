package com.cfm.tiri.services;

import com.cfm.tiri.domain.User;
import com.cfm.tiri.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Iterable<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> listActiveUsers(boolean active) {
		return userRepository.findByActive(active);
	}

	@Override
	public Iterable<User> listActiveAndFreeDrivers(long squadId) {
		return userRepository.findActiveAndFreeDrivers(squadId);
	}
	

}