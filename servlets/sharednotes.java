import java.sql.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class sharednotes extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {
    
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
       }catch(ClassNotFoundException e){
           e.printStackTrace();
       }


String toSend = "";    
String username = (String) req.getSession().getAttribute("username"); 
int i=0;
int j;

try
{
con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");
stmt=con.createStatement();

String sql ="select noteid from usersharednotes where receivername = '"+username+"'";
rs = stmt.executeQuery(sql);
String []arr = new String[1000];

for(j=0;rs.next();j++)
{
    i=1;
  arr[j] = rs.getString("noteid");
}
if(i==1)
{
for(int k=0;k<j;k++)
{
String sql1 ="select notename,notecontent from usernotes where noteid = "+arr[k]+"";
rs1 = stmt.executeQuery(sql1);
rs1.next();
String notename = rs1.getString("notename");
String notecontent = rs1.getString("notecontent");
i=1;
toSend = toSend + " <div style=' width: 295px; height: 200px;margin: 40px;border: 2px solid;'><h2 style='font-size:25px;border: 1px solid;position: relative;top: -22;'>"+notename+"</h2><p style='font-size:23px;position: relative;top: -36;'>"+notecontent+"</p></div>";
}
}
else
{
  toSend = "<h1>No result found!</h1>";
}


}catch (SQLException e) {
    e.printStackTrace();
   // System.out.println(e);
}

res.getWriter().write(toSend);
    }
}


