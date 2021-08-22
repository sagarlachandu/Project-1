package com.ers.service;

import java.util.List;

import com.ers.entity.SignupEntity;
import com.ers.model.Signup;

public interface SignupService {
	public boolean addEmployeeDetails(Signup signup);
	public List<SignupEntity> getEmployeeDetails(String userName);
	public boolean updateEmployeeDetails(Signup signup);
	public String getEmployeeType(String userName);
	public List<SignupEntity> getAllEmployees();
	public List<String> getUserNames();
	public boolean deleteEmployeeDetails(Signup signup);
}
