package com.bookstore.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
	public static Connection connectToDb()
	{
		 String dbStringURL = "jdbc:oracle:thin:@localhost:1521:xe";
		 Connection connection;
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Get the DB Connection
			try {
				connection = DriverManager.getConnection(dbStringURL,"shesha1096","shesha1096shankar");
				if(connection!=null)
				{
					//System.out.println("Connection Successful");
					return connection;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	}
	

}
