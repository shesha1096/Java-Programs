package com.bookstore.interfaces;

import java.sql.Connection;

import com.bookstore.model.Admin;

public interface AdminLoginDao {
	public boolean addUser(String username,String password,String mobile_number);
	public Admin loginAdmin(String username,String password);

}
