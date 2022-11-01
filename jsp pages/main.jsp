<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*,java.util.*,java.sql.*" %>

<html> 
<head>
<title>Notes web page</title> 	
<style>
    .share
    {
        position: relative;
        right: -140px;
        top: -25px;
    }
    
    .signout
    {
        
        position: relative;
        left: 1210px;
        top: -50px;
    }
    
    .sharednote
    {
        
        position: relative;
        left: 1210px;
        top: -20px;
    }
    
    .add
    {
        
        position: relative;
        left: 1210px;
        top: -35px;
    }
</style>
</head>
  
<body style="background-color:powderblue;" onload="notedata()">  

    <h1>My Notes</h1>

    <form action="searchcontent" method="post">
        <input style="font-size:20px;position: relative;right:  -373;" type="text" name="Snotename" placeholder="search..." size="30">
        <input style="font-size:15px;position: relative;right:  -370;top:-1;" type="submit" value="Search note">
    </form>
    
    <form action="signout" method="post">
        <div class="signout">
        <input  type="submit" value="Sign out">
        </div>
    </form>
    
    <form action="addnote.jsp" method="post">
        <div class="add">
        <input  type="submit" value="Add note">
        </div>
    </form>
    
    <form action="sharednotes.jsp" method="post">
        <div class="sharednote">
        <input  type="submit" value="Shared note">
        </div>
    </form>
    
    <div id="notedata" style="width:1140px;position: relative;right:-60px;top:-95px;display: flex;flex-wrap: wrap;"></div>

    <script>
        function notedata()
        {
          
           
            var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function() {
                        if (this.readyState == 4 && this.status == 200) 
                        {
                            document.getElementById("notedata").innerHTML = this.responseText;
                        }
                    }
                    xhttp.open("GET", "main");
                    xhttp.send();
        }
    </script>

     <script>
        function editnote(noteid)
        {
        var NoteName = document.getElementById("notename"+noteid).value;
        var NoteContent = document.getElementById("notecontent"+noteid).value;
        var id = document.getElementById("noteid"+noteid).value;
        var xhttp = new XMLHttpRequest();
        
        xhttp.open("GET", "editnote?name="+NoteName+"&content="+NoteContent+"&noteid="+id, true);
        xhttp.send();
        }
    </script>

<script>
    window.addEventListener( "pageshow", function ( event ) {
     var historyTraversal = event.persisted || ( typeof window.performance != "undefined" && window.performance.navigation.type === 2 );
    // console.log(historyTraversal);
     if ( historyTraversal ) {
       window.location.reload();
     }
   });
</script>




</body>  
</html> 