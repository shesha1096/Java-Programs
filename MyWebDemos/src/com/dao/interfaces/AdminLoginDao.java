package com.dao.interfaces;

import java.sql.Connection;

import com.classes.Admin;

public interface AdminLoginDao {
	public boolean addUser(String username,String password,String mobile_number);
	public Admin loginAdmin(String username,String password);

}

