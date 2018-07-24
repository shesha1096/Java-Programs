package com.classes.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserBean {
	private String username;
	private String password;
	private String type;
	private Connection connection;
	public UserBean() {
		super();
	}
	public UserBean(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}
	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
	
