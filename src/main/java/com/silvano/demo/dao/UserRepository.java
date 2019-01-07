package com.silvano.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silvano.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	

}
