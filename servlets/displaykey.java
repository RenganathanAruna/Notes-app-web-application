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

public class displaykey extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {

        Connection con = null;
        Statement stmt = null;  
        ResultSet rs = null;
        String toSend="";

        try{
        Class.forName("com.mysql.jdbc.Driver");
  
        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }

    try{
        con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701"); 
        String regname = (String) req.getSession().getAttribute("reg");
       // System.out.println(regname);
   
        stmt=con.createStatement();
        String sql ="select authenticationG,authenticationM from userdetails where username = '"+regname+"'";
        rs = stmt.executeQuery(sql);
        rs.next() ;  
        
        String authenG = rs.getString("authenticationG");
       //System.out.println(regname);
        String authenM = rs.getString("authenticationM");
       //System.out.println(regname);

        toSend = toSend + "please note down the Google authenticator key:<br></br>"+authenG+"<br></br><br></br>please note down the Microsoft authenticator key:<br></br>"+authenM+"<br></br>Once done please click the Done tag below...<br></br><a style='position: relative;right: -200;' href='login.jsp'>Done</a>";

    }catch (SQLException e) {
		e.printStackTrace();
		System.out.println(e);
    }


    
      //System.out.println(toSend);
      res.getWriter().write(toSend);
       
}
}
