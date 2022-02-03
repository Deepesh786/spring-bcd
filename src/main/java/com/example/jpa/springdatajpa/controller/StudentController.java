package com.example.jpa.springdatajpa.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.springdatajpa.entity.Student;
import com.example.jpa.springdatajpa.service.SpringContext;
import com.example.jpa.springdatajpa.service.StudentService;
import com.example.jpa.springdatajpa.service.Impl.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService service ;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
//	@Autowired
//	private StudentServiceImpl impl;

//	@Autowired
//	public StudentController(StudentService service) {
//		this.service = service;
//	}
//	

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping(path = "/save")
	public ResponseEntity<String> save(@RequestBody String body) throws JsonMappingException, JsonProcessingException {
		JSONObject studentObj = new JSONObject(body);
		//StudentService service = SpringContext.getBean(StudentService.class);
		StudentService serviceDP = applicationContext.getBean(StudentService.class);
		
		Student student = new ObjectMapper().readValue(studentObj.toString(), Student.class);

		student = serviceDP.updateEmployee(student);
		
		return new ResponseEntity<>(student.toString(),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<String> getAllStudent() {
		
		List<Student> student = service.getAllEmployeeList();
		return new ResponseEntity<>(student.toString(),HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteByEmailId/{emailId}")
	public ResponseEntity<String> deleteProperty(
			@PathVariable(required = true, value = "emailId") @NotNull @NotEmpty String emailId) {
			service.deleteEmployee(emailId);
			//impl.deleteEmployee(emailId);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}

}