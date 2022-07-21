package com.service.bcd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.springdatajpa.Response.ApiResponse;

@RequestMapping("/Test")
@RestController
public class TestController {

	@GetMapping(path = "/v1")
	public ResponseEntity<ApiResponse<String>> getAllStudent() {

		ApiResponse<String> response = new ApiResponse<>("Yupp!!");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
