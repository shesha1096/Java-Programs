package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.bean.UserBean;
import com.dao.classes.UserDao;
import com.utilities.DbConnection;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		RequestDispatcher loginDispatcher = request.getRequestDispatcher("login.jsp");
		loginDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");
		switch(action)
		{
		case "Sign in":
			String username = request.getParameter("username");
			String password=  request.getParameter("password");
			System.out.println(username);
			UserDao userDao = new UserDao();
			boolean flag = userDao.validateUser(username, password);
			if(flag)
			{
			//System.out.println("User Bean: "+userBean.getUsername());
			RequestDispatcher movieDispatcher = request.getRequestDispatcher("movielist.jsp");
			movieDispatcher.forward(request, response);
			}
			else
			{
				response.getWriter().println("<h1> Cannot validate user</h1>");
			}
			break;
			
		}
		
	}

}
