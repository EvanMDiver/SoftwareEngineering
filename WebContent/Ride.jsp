<%@page import="rides.RideRequestController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Guest Rides</title>
</head>
<body>
<form name="regform" action="RequestRide" method="post">
  <img src="Images/form.jpg" style="width:100%">

  <br>
  <br>
  	Time
  <br>
  	<input type="text" name="Time" value=" ">
  <br>
  Pick-Up address:<br>
  <input type="text" name="Pick-UpX" value=" ">
  <input type="text" name="Pick-UpY" value=" ">
  <br>
  Destination address:<br>
  <input type="text" name="DestinationX" value=" ">
  <input type="text" name="DestinationY" value=" ">
  <br>
  <input type="submit" value="Submit" name="submit">
</form> 


</body>
</html>