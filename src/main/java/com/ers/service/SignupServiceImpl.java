package com.ers.service;

import java.util.List;

import com.ers.dao.LoginCredentialsDAO;
import com.ers.dao.LoginCredentialsDAOImpl;
import com.ers.dao.SignupDAO;
import com.ers.dao.SignupDAOImpl;
import com.ers.entity.SignupEntity;
import com.ers.model.Signup;

public class SignupServiceImpl implements SignupService {
	SignupDAO signupDAOImpl = new SignupDAOImpl();

	public boolean addEmployeeDetails(Signup signup) {
		return signupDAOImpl.addEmployeeDetails(signup);
	}

	public List<SignupEntity> getEmployeeDetails(String userName) {
		return signupDAOImpl.getEmployeeDetails(userName);
	}

	public boolean updateEmployeeDetails(Signup signup) {
		return signupDAOImpl.updateEmployeeDetails(signup);
	}

	public String getEmployeeType(String userName) {
		return signupDAOImpl.getEmployeeType(userName);
	}

	public List<SignupEntity> getAllEmployees() {
		return signupDAOImpl.getAllEmployees();
	}

	public List<String> getUserNames() {
		return signupDAOImpl.getUserNames();
	}

	public boolean deleteEmployeeDetails(Signup signup) {
		return signupDAOImpl.deleteEmployeeDetails(signup);
	}
}