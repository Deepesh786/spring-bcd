package com.example.jpa.springdatajpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import com.example.jpa.springdatajpa.converters.DateConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@MappedSuperclass
public class CommonDataEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(generator = "UUID")
	//@GenericGenerator(name = "UUID", strategy = "com.example.jpa.springdatajpa.service.UUIDIdentifier")
	//@JsonProperty("studentid")
	//@Value("${UUID.randomUUID().toString()}")
	@Column(name = "id")
	private String id;
	
	//@JsonSerialize(converter = DateConverter.class)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "created_time")
	@CreatedDate
	private String createdTime;
	
	 @PrePersist
	 protected void prePersist() {
	        if (this.createdTime == null) createdTime = new DateConverter().convert(new Date());
	    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
}
