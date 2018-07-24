package com.bean;

import java.sql.Date;

public class Complaint {
	private Long complaintId;
	private String text;
	private String status;
	private Date dateOfComplaint;
	private Customer customer;
	public Complaint() {
		super();
	}
	public Complaint( String text, String status, Date date,Customer customer) {
		super();
		this.text = text;
		this.status = status;
		this.dateOfComplaint = date;
		this.customer = customer;
	}
	public Long getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getDateOfComplaint() {
		return dateOfComplaint;
	}
	public void setDateOfComplaint(Date dateOfComplaint) {
		this.dateOfComplaint = dateOfComplaint;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
