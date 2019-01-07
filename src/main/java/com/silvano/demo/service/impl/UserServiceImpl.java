package com.silvano.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silvano.demo.dao.UserRepository;
import com.silvano.demo.model.User;
import com.silvano.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	protected UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
		
	}
}
