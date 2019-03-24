# SoftwareEngineering
Group 2 Project
<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-img {
  /* The image used */
  background-image: url("file:///C:/Web_Applications_CS3354/SoftwareEngineering/WebContent/Images/ride.jpg");

  min-height: 550px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

/* Add styles to the form container */
.container {
  position: absolute;
  right: 0;
  margin: 20px;
  max-width: 300px;
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit button */
.btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
</style>
</head>
<body>




  </body>
</div>
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
	<h2>Taxi Service</h2>
<div class="bg-img">
  <form name="loginform" action="LoginController" class="container" method="post" onsubmit="return loginValidate()" >
    <br>
    ${message}<br>
	${successMessage}<br>
    <h1>Login</h1>
    

    <label for="username"><b>Username</b></label>
    <input type="text"  name="username"  id="username" required>

    <label for="psw"><b>Password</b></label>
    <input type="password"  name="password" id="password" required>
    
	<a href="register.jsp" class="">Register</a>
	 <a href="contact.jsp" class="">Contact</a>
      <a href="home.jsp" class="">Guest</a>
    
    
		<input type="submit" name="submit" class="btn" value="login"><br>
	
   
  </form>

 </div>
 
	
	<form name="loginform" action="LoginController" method="post" onsubmit="return loginValidate()" >
	<br>
	${message}<br>
	${successMessage}<br>
	
	
	
	
	</form>
</body>
</html>
