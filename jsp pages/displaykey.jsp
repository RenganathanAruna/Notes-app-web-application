<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*,java.sql.*" %>
<html> 
<title>key display page</title> 
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
<body onload="displaykeys()">  
<div class="main"></div>
<div id="displaykey" style="position: relative;font-size:23px;position: relative;right: -428;top:-608;height: 775px;"></div>

<script>
    window.addEventListener( "pageshow", function ( event ) {
     var historyTraversal = event.persisted || ( typeof window.performance != "undefined" && window.performance.navigation.type === 2 );
    // console.log(historyTraversal);
     if ( historyTraversal ) {
       window.location.reload();
     }
   });
</script>


<script>
   function displaykeys()
   {
       var xhttp = new XMLHttpRequest();
               xhttp.onreadystatechange = function() {
                   if (this.readyState == 4 && this.status == 200) 
                   {
                       document.getElementById("displaykey").innerHTML = this.responseText;
                   }
               }
               xhttp.open("GET", "displaykey");
               xhttp.send();
   }
</script>


</body>  
</html>  