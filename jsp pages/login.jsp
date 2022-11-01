<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*" %>

<html>
<head>
<style>

 .main
 {
    background-image: url("wp.jpg");
    position: relative;
    top: -113px;
    left: -8px;
    width: 1349px;
    height: 776px;
    background-repeat: no-repeat;
    background-size: cover;
 }

</style>
</head>
<title>login page</title> 
<body>  

<div class="main">
<img src="userwp.png" alt="wp" width="200" height="200"  style="position: relative; top: 240px;right: -562px;">
<form style="position: relative;right: -524;width: 700;top:296;height: 300;" action="login" method="post">  
Email Id:<input type="email" name="userEmail" size="40px"/><br/><br/>  
Password :<input type="password" name="userPass"/><br/><br/>     
<input type="submit" value="login"/>  
<a style="position: relative;right: -30px" href="Register.jsp">Register</a>
</form> 
</div>
</body>
</html>