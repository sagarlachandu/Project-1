package com.ers.util;

import java.util.HashSet;
import java.util.Set;

import com.ers.entity.LoginCredentialsEntity;
import com.ers.entity.ReimbursementRequestEntity;
import com.ers.entity.SignupEntity;
import com.ers.model.ReimbursementRequest;
import com.ers.model.Signup;

public class ReimbursementRequestMapper {
	public static ReimbursementRequestEntity mapReimbursementRequest(ReimbursementRequest reimbursementRequest,String email) {
		System.out.println("In mapper begin");
		ReimbursementRequestEntity reimbursementRequestEntity = new ReimbursementRequestEntity();
		Set<ReimbursementRequestEntity> reqSet=new HashSet<ReimbursementRequestEntity>();
		SignupEntity signupEntity = new SignupEntity();
		signupEntity.setEmail(email);
		System.out.println(signupEntity);
		reimbursementRequestEntity.setReqId(reimbursementRequest.getReqId());
		reimbursementRequestEntity.setReqType(reimbursementRequest.getReqType());
		reimbursementRequestEntity.setReqAmount(reimbursementRequest.getReqAmount());
		reimbursementRequestEntity.setReqDate(reimbursementRequest.getReqDate());
		reimbursementRequestEntity.setReqStatus(reimbursementRequest.getReqStatus());
		reimbursementRequestEntity.setReqDescription(reimbursementRequest.getReqDescription());
		reimbursementRequestEntity.setReqActionDate(reimbursementRequest.getReqActionDate());
		reimbursementRequestEntity.setReqActionRemarks(reimbursementRequest.getActionRemarks());
		reimbursementRequestEntity.setUserEmail(signupEntity);
		System.out.println(reimbursementRequestEntity);
		
		System.out.println("In mapper end");
		return reimbursementRequestEntity;
	}
}