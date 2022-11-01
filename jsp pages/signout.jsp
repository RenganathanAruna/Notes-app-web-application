<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*,java.sql.*" %>

<html> 
<body onload="back()">
<script>
function back()
{
   let Backlen = history.length; 
   Backlen=Backlen-2;
   console.log(Backlen);
   history.go(-Backlen);
}
</script>
</body>
</html>