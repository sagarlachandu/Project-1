package com.ers.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ers.entity.ReimbursementRequestEntity;
import com.ers.entity.SignupEntity;
import com.ers.model.Signup;
import com.ers.util.Hibernateutil;
import com.ers.util.SignupMapper;

public class SignupDAOImpl implements SignupDAO {

	public boolean addEmployeeDetails(Signup signup) {
		// TODO Auto-generated method stub
		boolean getStatus = false;
		Session session = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			session.beginTransaction();
			SignupEntity sessionEntity = SignupMapper.mapSignup(signup);
			session.saveOrUpdate(sessionEntity);
			session.flush();
			session.getTransaction().commit();
			System.out.println("Data inserted successfully");
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

	public List<SignupEntity> getEmployeeDetails(String userName) {
		// TODO Auto-generated method stub
		List<SignupEntity> employeeList = new ArrayList<SignupEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM SignupEntity s where email=:userId");

			query.setParameter("userId", userName);
			employeeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employeeList;
	}
	public boolean updateEmployeeDetails(Signup signup) {
		// TODO Auto-generated method stub
		boolean getStatus = false;
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			SignupEntity signupEntity = SignupMapper.mapSignup(signup);
			session.find(SignupEntity.class, signup.getEmail());
			SignupEntity signupEntity1 = session.load(SignupEntity.class, signup.getEmail());
			signupEntity1.setFirstName(signupEntity.getFirstName());
			signupEntity1.setLastName(signupEntity.getLastName());
			signupEntity1.setDateOfBirth(signupEntity.getDateOfBirth());
			signupEntity1.setAge(signupEntity.getAge());
			signupEntity1.setGender(signupEntity.getGender());
			signupEntity1.setEmail(signupEntity.getEmail());
			signupEntity1.setContactNo(signupEntity.getContactNo());
			signupEntity1.setAddress(signupEntity.getAddress());
			signupEntity1.setEmployeeType(signupEntity.getEmployeeType());
			session.merge(signupEntity1);
			session.flush();
			session.getTransaction().commit();
			System.out.println("Data updated successfully1");
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
	public String getEmployeeType(String userName) {
		// TODO Auto-generated method stub
		String empType = "";
		List<SignupEntity> employeeList = new ArrayList<SignupEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from SignupEntity s where email=:userId");
			query.setParameter("userId", userName);
			System.out.println("Before query");
			employeeList = query.list();
			System.out.println("After query");
			for (SignupEntity eList : employeeList) {
				empType = eList.getEmployeeType();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return empType;
	}
	public List<SignupEntity> getAllEmployees() {
		List<SignupEntity> allEmployeeList = new ArrayList<SignupEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM SignupEntity s where employeeType=:eType");
			query.setParameter("eType", "Employee");
			allEmployeeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allEmployeeList;
	}

	public List<String> getUserNames() {
		List<String> userNameList = new ArrayList<String>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query=session.createQuery("SELECT s.email FROM SignupEntity s");
			userNameList=query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return userNameList;
	}

	public boolean deleteEmployeeDetails(Signup signup) {
		boolean getStatus=false;
		Session session=Hibernateutil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			SignupEntity signupMappedEntity=SignupMapper.mapSignup(signup);
			session.find(SignupEntity.class, signupMappedEntity.getEmail());
			SignupEntity signupLoadedEntity=session.load(SignupEntity.class, signupMappedEntity.getEmail());
			session.delete(signupLoadedEntity);
			session.flush();
			session.getTransaction().commit();
			getStatus=true;
			System.out.println("Rows deleted!");
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally {
			if(session!=null)
			{
				session.close();
			}
		}
		return getStatus;
	}

}