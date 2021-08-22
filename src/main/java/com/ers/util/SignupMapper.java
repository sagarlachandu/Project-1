package com.ers.util;

import com.ers.entity.SignupEntity;
import com.ers.model.Signup;

public class SignupMapper {
	public static SignupEntity mapSignup(Signup signup) {
		SignupEntity signupEntity = new SignupEntity();
		signupEntity.setFirstName(signup.getFirstName());
		signupEntity.setLastName(signup.getLastName());
		signupEntity.setDateOfBirth(signup.getDateOfBirth());
		signupEntity.setAge(signup.getAge());
		signupEntity.setGender(signup.getGender());
		signupEntity.setEmail(signup.getEmail());
		signupEntity.setContactNo(signup.getContactNo());
		signupEntity.setAddress(signup.getAddress());
		signupEntity.setEmployeeType(signup.getEmployeeType());
		return signupEntity;
	}
}