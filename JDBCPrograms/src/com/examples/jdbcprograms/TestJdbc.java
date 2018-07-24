package com.examples.jdbcprograms;

import java.util.ArrayList;
import java.util.List;

public class TestJdbc {
	
	public static void main(String[] args)
	{
		LoginDao loginDao = new LoginDao();
		//System.out.println(loginDao.addLogin("micheal", "micheal1096", "user")+" record added");
		System.out.println(loginDao.loginDelete("micheal")+" record deleted");
		
		
	}

}
