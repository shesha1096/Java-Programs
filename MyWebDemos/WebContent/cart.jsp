<%@page import="com.classes.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.classes.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#books {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}



#books tr:nth-child(even){background-color: #f2f2f2;}

#books tr:hover {background-color: #ddd;}

#books th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
h1{
	text-align: center;
}
</style>
</head>
<body>
<% session = request.getSession(false); %>
<h1> Welcome to your cart </h1>
<form>
<table id="books">
<tr>
<th> ISBN</th>
<th> Book Name </th>
<th> Author Name </th>
<th> Price </th>
</tr>
<% List<Book> bookList = (ArrayList<Book>) session.getAttribute("list");
Cart cart = (Cart) session.getAttribute("cartlist");
	for(Book book: cart.getBookList())
	{
%>
<tr>
<td><%= book.getBookIsbn() %></td>
<td><%= book.getBookName() %></td>
<td><%= book.getAuthorName() %></td>
<td><%= book.getPrice() %></td>

</tr>
<% } %>
</table>
<input type="submit" name="action" value="Generate Bill"/>
</form>
</body>
</html>