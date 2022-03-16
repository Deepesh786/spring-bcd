package com.example.jpa.springdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.jpa.springdatajpa.annotation.UniqueKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.NonNull;

@Entity
@Table(name = "bcd_user")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends CommonDataEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@UniqueKey
	@Column(name = "loginid", length = 50, unique = true)
	@NonNull
	@Size(min = 1, max = 50)
	private String loginId;
	
	@JsonIgnore
	@Column(name = "password", length = 100)
	@NonNull
	@Size(min = 1, max = 100)
	private String password;
	
	@Column(name = "mobile" , length = 15)
	@Pattern(regexp = "(^[0-9]*$)")
	private String mobile;
	
	@Column(name = "name" , length = 10)
	private String name;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", mobile=" + mobile + ", name=" + name + "]";
	}
	
	
}
