package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
	private static Connection connection;
	

	public DbUtility(String url,String driverUrl,String username,String password)
	{
		 String dbStringURL =url;
		 
		{
			try {
				Class.forName(driverUrl);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Get the DB Connection
			try {
				connection = DriverManager.getConnection(dbStringURL,username,password);
				if(connection!=null)
				{
					System.out.println("Connection Successful");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	}
	public static Connection getConnection()
	{
		return connection;
	}
	
	

}