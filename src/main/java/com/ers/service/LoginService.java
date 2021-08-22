package com.ers.service;

import java.util.List;

import com.ers.entity.LoginCredentialsEntity;

public interface LoginService {
	public List<LoginCredentialsEntity> validateUser();

	public boolean updateForgotPassword(String userName, String passWord);
	public boolean resetForgotPassword(String userName,String newPassWord,String currentPassWord);
}