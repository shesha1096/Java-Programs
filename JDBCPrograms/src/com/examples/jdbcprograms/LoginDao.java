package com.examples.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	private String dbStringURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private Connection connection;
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
				System.out.println("Connection Successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//addLogin
	public int addLogin(String username,String password,String role)
	{
		
		try {
			String insertQuery = "insert into login values(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, role);
			
			int n = statement.executeUpdate(); //returns number of rows updated
			if(n>0)
			{
				return n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return 0;
	}
	public int loginDelete(String username)
	{
		String deleteQuery = "delete from login where username=?";
		PreparedStatement deleteStatement=null;
		if(searchLogin(username))
		{
		try {
			deleteStatement = connection.prepareStatement(deleteQuery);
			deleteStatement.setString(1, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int n= deleteStatement.executeUpdate();
			if(n>0)
			{
				return n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return 0;
		
	}
	private boolean searchLogin(String username) {
		// TODO Auto-generated method stub
		String searchQuery = "select * from login";
		Statement searchStatement;
		try {
			searchStatement = connection.createStatement();
			ResultSet rs = searchStatement.executeQuery(searchQuery);
			while(rs.next())
			{
				if(rs.getString(1).equals(username))
				{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
