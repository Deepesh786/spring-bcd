package com.example.jpa.springdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(value = Include.NON_NULL)
public class Student {

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
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "com.example.jpa.springdatajpa.service.UUIDIdentifier")
	//@JsonProperty("studentid")
	//@Value("${UUID.randomUUID().toString()}")
	@Column(name = "studentid")
	private String studentId;
	
	
	//@JsonProperty("firstName")
	@Column(name = "firstname" )
	private String firstName;
	
	
	@Column(name = "lastname")
	private String lastName;

	@Column(
			name = "emailid",
			nullable = false
			)
	private String emailId;
	
	@Column(name = "guardianname")
	private String guardianName;
	
	@Column(name = "guardianemail")
	private String guardianEmail;
	
	@Column(name = "guardianmobile")
	private String guardianMobile;

	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", guardianName=" + guardianName + ", guardianEmail=" + guardianEmail + ", guardianMobile="
				+ guardianMobile + "]";
	}
	
	
	
}
