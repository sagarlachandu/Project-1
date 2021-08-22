package com.ers.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ers.entity.ReimbursementRequestEntity;
import com.ers.entity.SignupEntity;
import com.ers.model.ReimbursementRequest;
import com.ers.model.Signup;
import com.ers.util.Hibernateutil;
import com.ers.util.ReimbursementRequestMapper;

public class ReimbursementRequestDAOImpl implements ReimbursementRequestDAO {

	public boolean addReimbursementRequestDetails(ReimbursementRequest reimbursementRequest, String email) {
		boolean getStatus = false;
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			System.out.println("before mapper");
			ReimbursementRequestEntity re = ReimbursementRequestMapper.mapReimbursementRequest(reimbursementRequest,
					email);
			System.out.println(re);
			session.beginTransaction();
			session.save(re);
			System.out.println("after mapper");
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

	public List<SignupEntity> getParticularUser(String email) {
		// TODO Auto-generated method stub
		List<SignupEntity> employeeList = new ArrayList<SignupEntity>();
		System.out.println(email);
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM SignupEntity s where email=:userName");
			query.setParameter("userName", email);
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

	public List<ReimbursementRequestEntity> getParticularUserPendingRequests(String userName) {
		List<ReimbursementRequestEntity> pendingList = new ArrayList<ReimbursementRequestEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("FROM ReimbursementRequestEntity r where email=:userId and reqStatus=:status");

			query.setParameter("userId", userName);
			query.setParameter("status", "Pending");
			pendingList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return pendingList;
	}

	public List<ReimbursementRequestEntity> getParticularUserApprovedRequests(String userName) {
		List<ReimbursementRequestEntity> approvedList = new ArrayList<ReimbursementRequestEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("FROM ReimbursementRequestEntity r where email=:userId and reqStatus=:status");

			query.setParameter("userId", userName);
			query.setParameter("status", "Accepted");
			approvedList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return approvedList;
	}

	public List<ReimbursementRequestEntity> getParticularUserDeniedRequests(String userName) {
		List<ReimbursementRequestEntity> rejectedList = new ArrayList<ReimbursementRequestEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("FROM ReimbursementRequestEntity r where email=:userId and reqStatus=:status");

			query.setParameter("userId", userName);
			query.setParameter("status", "Denied");
			rejectedList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rejectedList;
	}

	public List<ReimbursementRequestEntity> getParticularUserAllRequests(String userName) {
		List<ReimbursementRequestEntity> allRequestList = new ArrayList<ReimbursementRequestEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM ReimbursementRequestEntity r where email=:userId");

			query.setParameter("userId", userName);
			allRequestList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allRequestList;
	}

	public List<ReimbursementRequestEntity> getAllPendingRequests() {
		List<ReimbursementRequestEntity> allPendingRequestList = new ArrayList<ReimbursementRequestEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM ReimbursementRequestEntity r where reqStatus=:status");
			query.setParameter("status", "Pending");
			allPendingRequestList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allPendingRequestList;
	}

	public List<ReimbursementRequestEntity> getAllApprovedRequests() {
		List<ReimbursementRequestEntity> allApprovedRequestList = new ArrayList<ReimbursementRequestEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM ReimbursementRequestEntity r where reqStatus=:status");
			query.setParameter("status", "Accepted");
			allApprovedRequestList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allApprovedRequestList;
	}

	public List<ReimbursementRequestEntity> getAllDeniedRequests() {
		List<ReimbursementRequestEntity> allDeniedRequestList = new ArrayList<ReimbursementRequestEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM ReimbursementRequestEntity r where reqStatus=:status");
			query.setParameter("status", "Denied");
			allDeniedRequestList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allDeniedRequestList;
	}
	public List<String> getRequestIds() {
		List<String> allRequestIdList = new ArrayList<String>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session
					.createQuery("SELECT r.reqId FROM ReimbursementRequestEntity r where reqStatus=:status");
			query.setParameter("status", "Pending");
			allRequestIdList = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allRequestIdList;
	}
	public List<ReimbursementRequestEntity> getDetailsById(String requestId) {
		List<ReimbursementRequestEntity> RequestDetailsList = new ArrayList<ReimbursementRequestEntity>();
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("FROM ReimbursementRequestEntity r where reqId=:requestId");
			query.setParameter("requestId", requestId);
			RequestDetailsList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return RequestDetailsList;
	}
	public boolean updateRequestStatus(String requestId, String managerAction,String reqActionDate,String reqActionRemarks) {
		boolean getStatus = false;
		Session session = Hibernateutil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query=session.createQuery("UPDATE ReimbursementRequestEntity SET reqStatus=:status,reqActionDate=:actionDate,reqActionRemarks=:actionRemarks WHERE reqId=:requestId");
			query.setParameter("status",managerAction);
			query.setParameter("actionDate",reqActionDate);
			query.setParameter("actionRemarks", reqActionRemarks);
			query.setParameter("requestId", requestId);
			int count=query.executeUpdate();
			getStatus=true;
			session.getTransaction().commit();
			System.out.println(count+" "+"Rows Updated");
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