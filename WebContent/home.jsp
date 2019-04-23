<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>



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
  <form name="loginform" action="LoginControllerD" class="container" method="post" onsubmit="return loginValidate()" >
    <br>
    ${message}<br>
	${successMessage}<br>
    <h1>Driver Page</h1>
    

    <label for="username"><b>Username</b></label>
    <input type="text"  name="username"  id="username" required>

    <label for="psw"><b>Password</b></label>
    <input type="password"  name="password" id="password" required>
    
<a href="registerD.jsp" class="">Register</a>
    
    
		<input type="submit" name="submit" class="btn" value="login"><br>
	
   
  </form>

 </div>
    <br>
    ${message}<br>
	${successMessage}<br>
  

</style>
</head>
<body>






<!-- Navigation -->


</body>
</html>