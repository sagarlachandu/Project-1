package com.ers.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ers.entity.LoginCredentialsEntity;
import com.ers.entity.SignupEntity;
import com.ers.model.LoginCredentials;
import com.ers.model.Signup;
import com.ers.util.Hibernateutil;
import com.ers.util.LoginCredentialsMapper;
import com.ers.util.SignupMapper;

public class LoginCredentialsDAOImpl implements LoginCredentialsDAO {
	public boolean addLoginCredentials(LoginCredentials loginCredentials) {
		boolean getStatus = false;
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			 session.save(LoginCredentialsMapper.mapLoginCredentials(loginCredentials));
			session.getTransaction().commit();
			System.out.println("Data inserted successfully!");
			getStatus = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return getStatus;
	}

}