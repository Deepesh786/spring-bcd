package com.example.jpa.springdatajpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

import com.example.jpa.springdatajpa.entity.Student;
import com.example.jpa.springdatajpa.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RequestMapping("/student")
@RestController
public class StudentController {
	
	@Autowired
	private StudentService service ;
	
//	@Autowired
//	public StudentController(StudentService service) {
//		this.service = service;
//	}
//	
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(path ="/save")
	public Student save(@RequestBody String body) throws JsonMappingException, JsonProcessingException {
		JSONObject studentObj = new JSONObject(body);
		
		
		Student student= new ObjectMapper().readValue(studentObj.toString(), Student.class);
		
		student = service.updateEmployee(student);
		return student;
	}
	

}
