package com.example.jpa.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.springdatajpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	
}
