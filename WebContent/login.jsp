<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  
<style>
 
a:link {
  color: green;
  background-color: transparent;
  text-decoration: none;
}
a:visited {
  color: pink;
  background-color: transparent;
  text-decoration: none;
}
a:hover {
  color: red;
  background-color: transparent;
  text-decoration: underline;
}
a:active {
  color: yellow;
  background-color: transparent;
  text-decoration: underline;
}
</style>
</nav>


<section>

  <img class="mySlides" src="http://localhost:8080/SoftwareEngineering/Images/Taxi.jpg" style="width:100%">
 
</section>
<title>Login Page</title>
</head>
<body>
	<%out.print("Hello!"); %>
	<%= new java.util.Date() %>
	
	
	<%! int number1, number2; %>
	
	<%
		DbManager db = new DbManager();
		Connection conn = (Connection) db.getConnection();
		if(conn == null)
			out.print("failed");
		else
			out.print("succeeded");
		

	%>
	<br/>
	<nav>
 
  <a href="home.jsp" class="w3-button w3-bar-item">Home</a>
  <a href="register.jsp" class="w3-button w3-bar-item">Register</a>
 
  <a href="login.jsp" class="w3-button w3-bar-item">Login</a>
  <a href="contact.jsp" class="w3-button w3-bar-item">Contact</a>
  </nav>
	
	<form name="loginform" action="LoginController" method="post" onsubmit="return loginValidate()" >
	<br>
	${message}<br>
	${successMessage}<br>
	
	
	Username: <input type="text" name="username" id="username"><br>
	Password: <input type="password" name="password" id="password"><br>
	<input type="submit" name="submit" value="login"><br>
	
	
	</form>
</body>
</html>