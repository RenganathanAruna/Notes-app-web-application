<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*" %>



<html> 
<title>Register page</title>
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
<body>  


<div class="main">
    <script>
        window.addEventListener( "pageshow", function ( event ) {
             if ( event.persisted) {
               window.location.reload();
             }
           });
        </script>
<form style = "position: relative;right: -480;top: 315;" action="register" method="post">  
Name:<input type="text" name="userName" size="30"/><br/><br/>  
Phone number:<input type="text" name="phoneno"size="15"/><br/><br/> 
Date of birth:<input type="text" name="dob"size="15"/><br/><br/> 
Email id:<input type="text" name="email"size="50"/><br/><br/> 
Password:<input type="password" name="userPass"size="35"/><br/><br/>     
<input type="submit" value="register"/>  
</form>  
</div>


</body>  
</html>  