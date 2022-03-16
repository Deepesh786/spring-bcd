package com.example.jpa.springdatajpa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.jpa.springdatajpa.entity.User;
import com.example.jpa.springdatajpa.repository.UserRepository;

//@Component
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository ;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
}
