package com.ers.model;

public class ReimbursementRequest {
	private String reqId;
	private String reqType;
	private Double reqAmount;
	private String reqDate;
	private String reqDescription;
	private String reqStatus;
	private Integer loginId;
	private String email;
	private String reqActionDate;
	private String actionRemarks;

	public ReimbursementRequest() {
		super();
	}

	public ReimbursementRequest(String reqId, String reqType, Double reqAmount, String reqDate, String reqDescription,
			String reqStatus, String reqActionDate, String actionRemarks) {
		super();
		this.reqId = reqId;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.reqDate = reqDate;
		this.reqDescription = reqDescription;
		this.reqStatus = reqStatus;
		this.reqActionDate = reqActionDate;
		this.actionRemarks = actionRemarks;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public Double getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(Double reqAmount) {
		this.reqAmount = reqAmount;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getReqDescription() {
		return reqDescription;
	}

	public void setReqDescription(String reqDescription) {
		this.reqDescription = reqDescription;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public String getReqActionDate() {
		return reqActionDate;
	}

	public void setReqActionDate(String reqActionDate) {
		this.reqActionDate = reqActionDate;
	}

	public String getActionRemarks() {
		return actionRemarks;
	}

	public void setActionRemarks(String actionRemarks) {
		this.actionRemarks = actionRemarks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [reqId=" + reqId + ", reqType=" + reqType + ", reqAmount=" + reqAmount
				+ ", reqDate=" + reqDate + ", reqDescription=" + reqDescription + ", reqStatus=" + reqStatus
				+ ", loginId=" + loginId + ", email=" + email + ", reqActionDate=" + reqActionDate + ", actionRemarks="
				+ actionRemarks + "]";
	}

}
