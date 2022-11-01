<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*,java.sql.*" %>

<html> 
<title>Add note</title> 	
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
    <form style="position: relative;top: 360px;right:-390px;" action="createnote" method="post">
        <input style="font-size:17px" type="text" name="notename"  placeholder="Note name"/><br/><br/> 
        <textarea  style="font-size:20px" name="notecontent" rows="4" cols="50" placeholder="Enter the content of note" ></textarea><br></br>
        <input style="font-size:15px" type="submit" value="Add note">
    </form>
    </div>
</body>  
</html>  