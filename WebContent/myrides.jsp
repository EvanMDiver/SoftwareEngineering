<%@page import="rides.RideListController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Rides</title>
</head>
<body>
<h1>My Rides</h1>
	<div name="loginform" action="RideList" class="container" method="post"></div>
	<% RideListController rc = new RideListController();
	out.print(rc.getTable());%>
	
</body>
</html>