package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.Admin;
import com.classes.Book;
import com.classes.User;
import com.dao.classes.AdminLoginDao1;
import com.dao.classes.CustomerLoginDao1;
import com.utilities.DbUtility;


public class HelloServlet extends HttpServlet {
	private String url="";
	private String driverUrl="";
	private String dbusername="";
	private String dbpassword="";
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		url= getServletContext().getInitParameter("url");
		driverUrl = getServletContext().getInitParameter("driver");
		dbusername = getServletContext().getInitParameter("dbusername");
		dbpassword = getServletContext().getInitParameter("dbpassword");
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		//out.print("<h1 style='text-color:red;'>Hello from servlet </h1><br><p>This is my first servlet</p>");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		if(role.equals("Admin"))
		{
			AdminLoginDao1 adminValidate = new AdminLoginDao1();
			Admin admin = adminValidate.loginAdmin(username, password);
			if(admin!=null)
			{
				session = request.getSession(true);
				
				List<Book> bookList = new ArrayList<>();
				bookList =adminValidate.viewStore();
				//System.out.println(bookList.get(1).getBookName());
				RequestDispatcher dispatcher = request.getRequestDispatcher("bookstore.jsp");
				session.setAttribute("list", bookList);
				session.setAttribute("admin", admin);
				dispatcher.forward(request, response); 
				
			}
		}
		else if(role.equals("Customer"))
		{
			session = request.getSession(true);
			Connection connection = DbUtility.getConnection();
			if(connection!=null)
			{
			CustomerLoginDao1 customer = new CustomerLoginDao1();
			customer.setConnection(connection);
			User user = customer.checkUser(username, password);
			if(user!=null)
			{
				
				
				List<Book> bookList = new ArrayList<>();
				bookList =customer.viewStore();
				System.out.println(bookList.get(1).getBookName());
				RequestDispatcher dispatcher = request.getRequestDispatcher("bookstore.jsp");
				session.setAttribute("list", bookList);
				session.setAttribute("customer", user);
				dispatcher.forward(request, response); 
				
				
				
			}
			else
			{
				out.println("<h1>User does not exist</h1>");
			}
			}
			else
			{
				System.out.println("Could not establish connection");
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}