<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<title>choose authentication page</title> 	
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
	<form style="position: relative;right: -565px;top:400px;"action="otpoption" method="post">  
		<input type="radio" name="authentication" value="Google Authentication">Google Authentication<br></br>
		<input type="radio" name="authentication" value="Microsoft Authentication">Microsoft Authentication<br></br>
		<input style="position: relative;right: -7;"type="submit" value="submit">  <br/><br/> 
	</form> 
	</div> 
	</body>  
	</html>  