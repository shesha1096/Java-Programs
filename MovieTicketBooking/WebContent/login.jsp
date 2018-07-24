<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
#loginform
{
position: absolute;
  margin: auto;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  width: 100px;
  height: 100px;
  border-radius: 3px;
}
</style>
<script>
function checklogin(valuser) {     
    user = "";
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4){
            user = xmlhttp.responseText;
            alert("user: " + user);
            var divElement = document.getElementById('mydiv');
            divElement.innerHTML = user;
        } 
    }
    xmlhttp.open("GET","login.jsp?username="+valuser,true);
    xmlhttp.send(null); 
 }
 </script>
</head>
<body>
<h1 style="align:center"> Movie Booking System-Login</h1>
<form action="ms" id="loginform" method="post">
<input type="text" placeholder="Enter username" name="username" onblur="checklogin(this.value)" /><br/>
<input type="password" placeholder="Enter password" name="password"/><br/>
<input type="submit" name="action" value="Sign in"/>
 <div id="mydiv">
 </div>
</form>
</body>
</html>