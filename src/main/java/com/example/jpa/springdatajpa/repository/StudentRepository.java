package com.example.jpa.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.springdatajpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public void deleteByEmailId(String emailId) ;
	
}
