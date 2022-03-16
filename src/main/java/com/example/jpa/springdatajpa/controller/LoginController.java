package com.example.jpa.springdatajpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.springdatajpa.dto.Login;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
public class LoginController {

private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ApplicationContext applicationContext;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Login loginInput)throws JsonMappingException, JsonProcessingException {
		
		log.info(loginInput.toString());
		
		return new ResponseEntity<>("Success",HttpStatus.OK);
		
	}
}
