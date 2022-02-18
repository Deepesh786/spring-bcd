package com.example.jpa.springdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import com.example.jpa.springdatajpa.converters.JSONObjectConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
		name = "fk_student",
		uniqueConstraints = @UniqueConstraint(
		name = "emailid_unique",
		columnNames = "emailid"
				)
		)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Student extends CommonDataEntity {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


//	@Id
//	@SequenceGenerator(
//			name = "student_sequence",
//			sequenceName = "student_sequence",
//			allocationSize = 1
//			)
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "student_sequence"
//			)
	
	//@Id
	//@GeneratedValue(generator = "UUID")
	//@GenericGenerator(name = "UUID", strategy = "com.example.jpa.springdatajpa.service.UUIDIdentifier")
	//@JsonProperty("studentid")
	//@Value("${UUID.randomUUID().toString()}")
	//@Column(name = "studentid")
	//private String studentId;
	
	
	//@JsonProperty("firstName")
	@Column(name = "firstname" )
	private String firstName;
	
	@JsonIgnore
	@Column(name = "lastname")
	private String lastName;

	@Column(
			name = "emailid",
			nullable = false
			)
	private String emailId;
	
	@Column(columnDefinition = "json")
	@Convert(converter = JSONObjectConverter.class)
	private JsonNode attribute;
	
	@Column(name = "guardianname")
	private String guardianName;
	
	@Column(name = "guardianemail")
	private String guardianEmail;
	
	@Pattern(regexp="(^[0-9]*$)")
	@Column(name = "guardianmobile" , length = 12)
	private String guardianMobile;

	
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getGuardianEmail() {
		return guardianEmail;
	}

	public void setGuardianEmail(String guardianEmail) {
		this.guardianEmail = guardianEmail;
	}

	public String getGuardianMobile() {
		return guardianMobile;
	}

	public void setGuardianMobile(String guardianMobile) {
		this.guardianMobile = guardianMobile;
	}
	
	public JsonNode getAttribute() {
		return attribute;
	}

	public void setAttribute(JsonNode attribute) {
		this.attribute = attribute;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", attribute="
				+ attribute + ", guardianName=" + guardianName + ", guardianEmail=" + guardianEmail
				+ ", guardianMobile=" + guardianMobile + "]";
	}

	

	
	
	
	
}
