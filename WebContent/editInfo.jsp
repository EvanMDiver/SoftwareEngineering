<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>

</head>
<body>
<form name="regform" action="EditInfo" method="post" onsubmit="return regValidate()">
	<br>${message}<br>
	
	What is your Username: <input type="text" name="username"> <br>
	<div id="username_error"></div><br>
	
	
	Change Password: <input type="password" name="password" id="password"> 
	<br>
	Re-Type New Password: <input type="password" name="retry-password" id="retry-password"> 
	<br>
	<div id="password_error"></div><br>
	<input type="submit" name="submit" value="register" >
	<input type="reset" name="reset">
	
	</form>
	
	<a href="login.jsp">cancel</a>
	
</body>
</html>