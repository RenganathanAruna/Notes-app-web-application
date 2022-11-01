<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*,java.sql.*" %>
<html> 
<title>Searched notes</title> 
<body style="background-color:rgb(209, 197, 228);" onload="search()"> 
<h1>Search result...</h1>
<div id="searchresult" style="position: relative;width: 1310px;right: 4px;top: 10px; display: flex;flex-wrap: wrap;"></div>

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
    function search()
    {
        var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) 
                    {
                        document.getElementById("searchresult").innerHTML = this.responseText;
                    }
                }
                xhttp.open("GET", "searchnote");
                xhttp.send();
    }
</script>
</body>  
</html>  