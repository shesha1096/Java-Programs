package com.bookstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Admin {
	private String username;
	private String password;
	private String mobileNumber;
	
	public Admin() {
		super();
	}
	public Admin(String username, String password, String mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	

}
