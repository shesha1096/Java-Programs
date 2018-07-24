package com.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.interfaces.AdminLoginDao;
import com.dao.interfaces.BookStore;
import com.classes.Admin;
import com.classes.Book;
import com.classes.User;
import com.utilities.DbUtility;

public class AdminLoginDao1 implements AdminLoginDao,BookStore {
	private Connection connection;
	{
		 connection = DbUtility.connectToDb();
	}

	@Override
	public boolean addUser(String username,String password,String mobile_number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin loginAdmin(String username, String password) {
		// TODO Auto-generated method stub
		
		if(connection!=null)
		{
			String query = "select * from admin";
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet rs = statement.executeQuery();
				while(rs.next())
				{
					if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
					{
						Admin admin = new Admin();
						admin.setUsername(rs.getString(1));
						admin.setPassword(rs.getString(2));
						admin.setMobileNumber(rs.getString(3));
						return admin;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public  void addUser()
	{
		String query = "select * from request";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				User user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setMobileNumber(rs.getString(3));
				query = "delete from request where name='"+user.getUsername()+"'";
				pstmt = connection.prepareStatement(query);
				int n = pstmt.executeUpdate();
				if(n>0)
				{
				insertintoCustomer(user,connection);
				}
				else{
					return;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		  
	}
	public void insertintoCustomer(User user,Connection connection)
	{
		String query = "insert into customer values(?,?,?)";
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			pStmt.setString(1, user.getUsername());
			pStmt.setString(2, user.getPassword());
			pStmt.setString(3, user.getMobileNumber());
			int n = pStmt.executeUpdate();
			if(n>0)
			{
				
				System.out.println("Successfully inserted");
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteUser()
	{
		List<String> usersList = new ArrayList<>();
		
		String userQuery = "select username from customer";
		try {
			PreparedStatement deleteStatement = connection.prepareStatement(userQuery);
			ResultSet rs = deleteStatement.executeQuery();
			System.out.println("List of users:");
			while(rs.next())
			{
				User user = new User();
				
				System.out.println(rs.getString(1));
				usersList.add(rs.getString(1));
			}
			System.out.println("Enter the user that you want to delete");
			String user = new Scanner(System.in).nextLine();
			for(String userName : usersList)
			{
				if(userName.equals(user))
				{
					userQuery = "delete from customer where username='"+userName+"'";
					deleteStatement = connection.prepareStatement(userQuery);
					int n = deleteStatement.executeUpdate();
					if(n>0)
					{
						System.out.println("Successfully deleted");
					}
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addBooktoBookStore()
	{
		Book book = new Book();
		System.out.println("Enter the ISBN of the book");
		book.setBookIsbn(new Scanner(System.in).nextInt());
		System.out.println("Enter the name of the book");
		book.setBookName(new Scanner(System.in).nextLine());
		System.out.println("Enter the author name");
		book.setAuthorName(new Scanner(System.in).nextLine());
		System.out.println("Enter the stock available");
		book.setStock(new Scanner(System.in).nextInt());
		System.out.println("Enter the price of the book");
		book.setPrice(new Scanner(System.in).nextDouble());
		addBook(book);
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		String query = "insert into bookstore values(?,?,?,?,?)";
		try {
			PreparedStatement insertStatement = connection.prepareStatement(query);
			insertStatement.setInt(1, book.getBookIsbn());
			insertStatement.setString(2, book.getBookName());
			insertStatement.setString(3, book.getAuthorName());
			insertStatement.setDouble(4, book.getPrice());
			insertStatement.setInt(5, book.getStock());
			int n = insertStatement.executeUpdate();
			if(n>0)
			{
				System.out.println("Successfully inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void removeBook(Book book) {
		// TODO Auto-generated method stub
		
	}
	public List<Book> viewStore()
	{
		List<Book> bookList = new ArrayList<>();
		String query = "select * from bookstore";
		try {
			PreparedStatement pStatement = connection.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next())
			{
				Book book = new Book();
				book.setBookIsbn(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getDouble(4));
				book.setStock(rs.getInt(5));
				bookList.add(book);
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
		
	}


	
	
}