<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>

<style>
.container {
  position: relative;
  width: 100%;
  max-width: 400px;
}

.container img {
  width: 100%;
  height: auto;
}

.container .btn {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  background-color: #555;
  color: white;
  font-size: 16px;
  padding: 12px 24px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  text-align: center;
}

.container .btn:hover {
  background-color: black;
}
.container {
  position: relative;
  width: 100%;
  max-width: 400px;
}
.right{
  position: right;
  bottom: 8px;
  right: 16px;
}


</style>
</head>
<body>


<div class="container">
  <img src="file:///C:/Web_Applications_CS3354/SoftwareEngineering/WebContent/Images/ride.jpg" style="width:350%">
  <a href="Ride.jsp" class="w3-button w3-bar-item">
  <button class="btn">Want Ride?</button></a>
  
  	
</div>





<!-- Navigation -->
<nav class="w3-bar w3-black">
  <a href="Ride.jsp" class="w3-button w3-bar-item">Ride</a>


 
</nav>

</body>
</html>