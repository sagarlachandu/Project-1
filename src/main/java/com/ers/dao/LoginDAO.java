package com.ers.dao;

import java.util.List;

import com.ers.entity.LoginCredentialsEntity;

public interface LoginDAO {
	public List<LoginCredentialsEntity> validateUser();

	public boolean updateForgotPassword(String userName, String passWord);
	public boolean resetForgotPassword(String userName,String newPassWord,String currentPassWord);
}