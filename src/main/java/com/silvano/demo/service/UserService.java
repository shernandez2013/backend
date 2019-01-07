package com.silvano.demo.service;

import java.util.List;

import com.silvano.demo.model.User;

public interface UserService {

	/**
	 * save user data
	 * 
	 * @param user
	 * @return user created
	 */
	User save(User user);

	/**
	 * recovery list of existing users
	 * 
	 * @return existing user list
	 */
	List<User> findAll();

	/**
	 * delete user from data base
	 * 
	 * @param user
	 *            void
	 */
	void delete(User user);

}
