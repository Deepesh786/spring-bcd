package com.example.jpa.springdatajpa.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.springdatajpa.entity.Student;
import com.example.jpa.springdatajpa.repository.StudentRepository;
import com.example.jpa.springdatajpa.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository; 
	
	@Override
	public Student saveEmployee(Student student) {
		return repository.save(student);
	}

	@Override
	public Student updateEmployee(Student student) {
		return repository.saveAndFlush(student);
	}

	@Override
	public List<Student> getAllEmployeeList() {
		return repository.findAll();
	}

	@Override
	public Optional<Student> getEmployee(Long studentId) {
		
		return repository.findById(studentId);
	}

	@Override
	@Transactional
	public void deleteEmployee(String emailId) {

		//repository.deleteById(studentId);
		repository.deleteByEmailId(emailId);

	}
	
}
