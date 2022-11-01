<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*" %>
<html> 
<title>microsoft authentication page</title> 
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

    <script>
		window.addEventListener( "pageshow", function ( event ) {
		 var historyTraversal = event.persisted || ( typeof window.performance != "undefined" && window.performance.navigation.type === 2 );
		// console.log(historyTraversal);
		 if ( historyTraversal ) {
		   window.location.reload();
		 }
	   });
	</script>


<div class="main">
<form style="position: relative;top: 405px;right:-540px;"action="otpverifymicrosoft" method="post">  
Enter the OTP:<input type="text" name="otpM"/><br/><br/>       
<input type="submit" value="verify"/>  <br/><br/> 
</form>  
</div>
</body>  
</html>  