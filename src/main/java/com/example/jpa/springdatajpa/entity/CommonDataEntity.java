package com.example.jpa.springdatajpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class CommonDataEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "com.example.jpa.springdatajpa.service.UUIDIdentifier")
	//@JsonProperty("studentid")
	//@Value("${UUID.randomUUID().toString()}")
	@Column(name = "id")
	private String id;
	
	
	
}
