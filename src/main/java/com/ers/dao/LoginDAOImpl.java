package com.ers.dao;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ers.entity.LoginCredentialsEntity;
import com.ers.util.Hibernateutil;

public class LoginDAOImpl implements LoginDAO {

	public List<LoginCredentialsEntity> validateUser() {
		boolean status = false;
		List<LoginCredentialsEntity> loginList = new ArrayList<LoginCredentialsEntity>();
		try {
			Session session = Hibernateutil.getSessionFactory().openSession();
			Query query = session.createQuery("from LoginCredentialsEntity l");
			loginList = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

		}
		return loginList;
	}

	public boolean updateForgotPassword(String userName, String passWord) {
		boolean getStatus = false;
		List<Integer> loginIdList = new ArrayList<Integer>();
		List<String> passWordList = new ArrayList<String>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("select l.loginId from LoginCredentialsEntity l where l.userName=:userName");
			query.setParameter("userName", userName);
			loginIdList = query.list();
			int loginId = loginIdList.get(0);
			Query passWordQuery = session
					.createQuery("select l.passWord from LoginCredentialsEntity l where l.userName=:userName");
			passWordQuery.setParameter("userName", userName);
			passWordList = passWordQuery.list();
			String previousPassWord = passWordList.get(0);
			if (passWord.equals(previousPassWord)) {
				getStatus = false;
			} else {
				session.beginTransaction();
				Query updateQuery = session
						.createQuery("UPDATE LoginCredentialsEntity set passWord=:pwd" + " where loginId=:userId");
				updateQuery.setParameter("pwd", passWord);
				updateQuery.setParameter("userId", loginId);
				int count = updateQuery.executeUpdate();
				getStatus = true;
				System.out.println(count + " " + "Rows updated");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return getStatus;
	}
	public boolean resetForgotPassword(String userName, String newPassWord, String currentPassWord) {
		boolean getStatus = false;
		System.out.println(userName);
		System.out.println(newPassWord);
		System.out.println(currentPassWord);
		List<Integer> loginIdList = new ArrayList<Integer>();
		List<String> passWordList = new ArrayList<String>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("select l.loginId from LoginCredentialsEntity l where l.userName=:userName");
			query.setParameter("userName", userName);
			loginIdList = query.list();
			int loginId = loginIdList.get(0);
			System.out.println(loginId);
			Query passWordQuery = session
					.createQuery("select l.passWord from LoginCredentialsEntity l where l.userName=:userName");
			passWordQuery.setParameter("userName", userName);
			passWordList = passWordQuery.list();
			String previousPassWord = passWordList.get(0);
			System.out.println(previousPassWord);
			if (!currentPassWord.equals(previousPassWord)) {
				getStatus = false;
			} else {
				session.beginTransaction();
				Query updateQuery = session
						.createQuery("UPDATE LoginCredentialsEntity set passWord=:pwd" + " where loginId=:userId");
				updateQuery.setParameter("pwd", newPassWord);
				updateQuery.setParameter("userId", loginId);
				int count = updateQuery.executeUpdate();
				getStatus = true;
				System.out.println(count + " " + "Rows updated");
			}
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
