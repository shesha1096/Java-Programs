
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% session = request.getSession(false); %>
<h1>Welcome to BookStore</h1><a href="cart.jsp" > View Cart </a>
<table>


<tr><th>ISBN</th><th>TITLE</th><th>AUTHOR</th><th>PRICE</th><th>STOCK</th><th>BUY?</th></tr>


<c:forEach var="book" items="${list}">
<tr>
<td>${book.bookIsbn}</td>
<td>${book.bookName}</td>
<td>${book.authorName}</td>
<td>${book.price}</td>
<td>${book.stock}</td>
</tr>




</c:forEach>
</table>
</body>
</html>