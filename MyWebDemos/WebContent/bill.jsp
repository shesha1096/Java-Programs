<%@page import="java.util.Date"%>
<%@page import="com.classes.User"%>
<%@page import="com.classes.Book"%>
<%@page import="com.classes.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! double cost = 0.0;
Date d1 = new Date();%>
<% Cart cart = (Cart) session.getAttribute("cartlist");  %>

<% for(Book book: cart.getBookList())
	{
		cost += book.getPrice();
	}
User user = (User) session.getAttribute("customer"); 
	%>
<h1>Username: <%= user.getUsername() %></h1>
<h1> Date and Time of purchase: <%= d1 %></h1>
<h1> Total Cost: <%= cost %></h1>
<form action="ss">
<input type="submit" name="action" value="Sign Out"/>
</form>
</body>
</html>