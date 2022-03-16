package com.example.jpa.springdatajpa.controller;

import org.json.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.springdatajpa.Response.ApiResponse;
import com.example.jpa.springdatajpa.entity.User;
import com.example.jpa.springdatajpa.service.Impl.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/user")
public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ApplicationContext applicationContext;

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<User>> save(@RequestBody User user)throws JsonMappingException, JsonProcessingException {
		
		UserService service = applicationContext.getBean(UserService.class);
		user.setPassword("@1234");
		user = service.saveUser(user);
		
		
		return new ResponseEntity<>(new ApiResponse<>(user),HttpStatus.OK);
		
	}
}
