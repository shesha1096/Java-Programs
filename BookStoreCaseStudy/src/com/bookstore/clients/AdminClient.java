package com.bookstore.clients;

import java.sql.Connection;

import com.bookstore.dao.classes.AdminLoginDao1;
import com.bookstore.model.Admin;

public class AdminClient {
	public static void main(String[] args)
	{
		Admin admin = new Admin();
		AdminLoginDao1 adminLoginDao1 = new AdminLoginDao1();
		admin = adminLoginDao1.loginAdmin("hanks", "hanks1096");
		if(admin!=null)
		{
			System.out.println("Logged in");
			adminLoginDao1.addUser();
			//adminLoginDao1.deleteUser();
			adminLoginDao1.addBooktoBookStore();
		}
		else
		{
			System.out.println("Incorrect username/password");
		}
	}

}
