package com.bookstore.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bookstore.interfaces.CustomerLoginDao;
import com.bookstore.model.Book;
import com.bookstore.model.Cart;
import com.bookstore.model.User;
import com.bookstore.utilities.DbUtility;

public class CustomerLoginDao1 implements CustomerLoginDao {
	private Connection connection;
	{
		 connection = DbUtility.connectToDb();
		
	}

	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		
		
		if(connection!=null)
		{
			String query = "select username,password from customer";
			try {
				PreparedStatement pStatement = connection.prepareStatement(query) ;
				ResultSet rs = pStatement.executeQuery();
				while(rs.next())
				{
					if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
					{
						System.out.println("Successfully logged in");
						return true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}

	@Override
	public boolean loginUser() {
		// TODO Auto-generated method stub
		
		return false;
	}
	public void createUser(User user)
	{
		if(connection!=null)
		{
			String query = "insert into request values(?,?,?)";
			try {
				PreparedStatement pStatement = connection.prepareStatement(query);
				pStatement.setString(1, user.getUsername());
				pStatement.setString(2, user.getPassword());
				pStatement.setString(3, user.getMobileNumber());
				int n = pStatement.executeUpdate();
				if(n>0)
				{
					System.out.println("Successfully inserted");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void viewStore()
	{
		String query = "select * from bookstore";
		try {
			PreparedStatement pStatement = connection.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addBookToCart()
	{
		
		
		Cart cart=new Cart();
		System.out.println("Select the book name that you want to add to cart");
		String bookName = new Scanner(System.in).nextLine();
		String query = "select * from bookstore where bookname='"+bookName+"'";
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
				if(bookName.equals(book.getBookName()))
				{
					cart.addBookToCart(book);
				}
				else
				{
					System.out.println("Book not found.");
				}
				
				
			}
			createCartTable(cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
	}
	public void createCartTable(Cart cart)
	{
		String query = "create table cart"
				+ "("
				+ "isbn number(5) primary key,"
				+ "bookname varchar2(30) not null,"
				+ "authorname varchar2(30),"
				+ "price number(5,2),"
				+ "quantity number"
				+ ")";
		try {
			PreparedStatement createStatement = connection.prepareStatement(query);
			int n = createStatement.executeUpdate();
			String insertQuery = "insert into cart values(?,?,?,?,?)";
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
			for(Book book: cart.getBookList())
			{
				insertStatement.setInt(1, book.getBookIsbn());
				insertStatement.setString(2, book.getBookName());
				insertStatement.setString(3, book.getAuthorName());
				insertStatement.setDouble(4, book.getPrice());
				insertStatement.setInt(5, book.getStock());
				n = insertStatement.executeUpdate();
				if(n>0)
				{
					System.out.println("Successfully inserted");
					String deleteQuery = "drop table cart";
					PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
					boolean flag = deleteStatement.execute();
					if(flag)
					{
						System.out.println("Table deleted");
					}
				}
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}