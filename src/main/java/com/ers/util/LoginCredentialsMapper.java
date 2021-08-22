package com.ers.util;

import com.ers.entity.LoginCredentialsEntity;
import com.ers.entity.SignupEntity;
import com.ers.model.LoginCredentials;

public class LoginCredentialsMapper {
	public static LoginCredentialsEntity mapLoginCredentials(LoginCredentials loginCredentials) {
		LoginCredentialsEntity loginCredentialsEntity = new LoginCredentialsEntity();
		SignupEntity signupEntity = new SignupEntity();
		signupEntity.setEmail(loginCredentials.getUserName());
		loginCredentialsEntity.setUser(signupEntity);
		loginCredentialsEntity.setUserName(loginCredentials.getUserName());
		loginCredentialsEntity.setPassWord(loginCredentials.getPassWord());
		System.out.println(loginCredentialsEntity);
		return loginCredentialsEntity;
	}
}