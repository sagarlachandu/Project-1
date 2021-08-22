package com.ers.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "employee5")
public class SignupEntity {
	@OneToMany(mappedBy="userEmail",fetch=FetchType.EAGER, orphanRemoval=true)
	private Set<ReimbursementRequestEntity> reimbursementRequests;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String dateOfBirth;
	@Column(nullable = false)
	private Integer age;
	@Column(nullable = false)
	private String gender;
	@Id
	private String email;
	@Column(nullable = false)
	private String contactNo;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String employeeType;
	@OneToOne(mappedBy = "user",cascade=CascadeType.ALL, orphanRemoval=true)
	private LoginCredentialsEntity loginCredentialsEntity;
	public SignupEntity() {
		super();
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public LoginCredentialsEntity getLoginCredentialsEntity() {
		return loginCredentialsEntity;
	}

	public void setLoginCredentialsEntity(LoginCredentialsEntity loginCredentialsEntity) {
		this.loginCredentialsEntity = loginCredentialsEntity;
	}

	public Set<ReimbursementRequestEntity> getReimbursementRequests() {
		return reimbursementRequests;
	}

	public void setReimbursementRequests(Set<ReimbursementRequestEntity> reimbursementRequests) {
		this.reimbursementRequests = reimbursementRequests;
	}

	@Override
	public String toString() {
		return "SignupEntity [reimbursementRequests=" + reimbursementRequests + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", contactNo=" + contactNo + ", address=" + address + ", employeeType="
				+ employeeType + ", loginCredentialsEntity=" + loginCredentialsEntity + "]";
	}



}