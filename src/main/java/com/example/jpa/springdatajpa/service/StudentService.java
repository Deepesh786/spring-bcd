package com.example.jpa.springdatajpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.jpa.springdatajpa.entity.Student;

//@Component
public interface StudentService {

	Student saveEmployee(Student student);
	
	Student updateEmployee(Student student);
	
	List<Student> getAllEmployeeList();
	
	Optional<Student> getEmployee(Long studentId);
	
	void deleteEmployee(String emailId);
	
	
}
