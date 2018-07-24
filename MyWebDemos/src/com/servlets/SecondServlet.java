package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.Book;
import com.classes.Cart;


public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("action");
		String[] bookstoBuy=null;
		HttpSession session = request.getSession(false);
		Cart cart = new Cart();
		List<Book> books =  new ArrayList<>();
		switch(option)
		{
		case "Buy": bookstoBuy = request.getParameterValues("checkbox");
			for(String b: bookstoBuy)
			{
				System.out.println(b);
			}
		
			books =(ArrayList<Book>) session.getAttribute("list");
			if(books==null)
			{
				System.out.println("Null");
			}
			else
			{
			for(String book: bookstoBuy)
			{
				System.out.println(book);
				
			}
			
			
			for(Book book: books)
			{
				for(int i=0; i<bookstoBuy.length; i++)
				{
					if(book.getBookIsbn()==Integer.parseInt(bookstoBuy[i]))
					{
						cart.getBookList().add(book);
					}
				}
			}
			for(Book book: cart.getBookList())
			{
				System.out.println(book.getBookName());
			}
			
			
			}
		
		session.setAttribute("cartlist", cart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
		dispatcher.forward(request, response);
		
		break;
		case "Generate Bill":
			RequestDispatcher dispatchToBill = request.getRequestDispatcher("bill.jsp");
			dispatchToBill.forward(request, response);
			break;
		case "Sign Out": 
			RequestDispatcher signOut = request.getRequestDispatcher("login.html");
			signOut.forward(request, response);
			session.invalidate();
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}