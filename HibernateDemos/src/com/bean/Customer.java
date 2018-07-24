package com.bean;

import java.util.List;

public class Customer {
	private List<Complaint> complaints;
	private String userName;
	private String emailId;
	public Customer() {
		super();
	}
	public Customer( String userName, String emailId) {
		super();
		this.userName = userName;
		this.emailId = emailId;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
