<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*,java.sql.*" %>
<html> 
<title>Shared note</title> 
<body style="background-color:rgba(241, 213, 223, 0.959);" onload="sharednote()"> 
<h1>Shared Notes</h1>
<div id="sharedresult" style="width: 1140px;position: relative;right: -60;top: 10px;display: flex;flex-wrap: wrap;"></div>

<script>
    window.addEventListener( "pageshow", function ( event ) {
     var historyTraversal = event.persisted || ( typeof window.performance != "undefined" && window.performance.navigation.type === 2 );
   //  console.log(historyTraversal);
     if ( historyTraversal ) {
       window.location.reload();
     }
   });
</script>


<script> 
    function sharednote()
    {
        var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) 
                    {
                        document.getElementById("sharedresult").innerHTML = this.responseText;
                    }
                }
                xhttp.open("GET", "sharednotes");
                xhttp.send();
    }

</script>
</body>  
</html>  