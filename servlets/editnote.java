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


public class editnote extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {
    
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
       }catch(ClassNotFoundException e){
           e.printStackTrace();
       }


       
        int userid = (int) req.getSession().getAttribute("userid");
      //  System.out.println(userid);
        String notename=(String)req.getParameter("name");
      //  System.out.println(notename);
        String notecontent=(String)req.getParameter("content");
      //  System.out.println(notecontent);
        String noteid = (String)req.getParameter("noteid");
      //  System.out.println(noteid);



        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");
            stmt=con.createStatement();

            String s = "update usernotes set notename='"+notename+"' where noteid="+noteid+"";
            stmt.executeUpdate(s);

            String s1 = "update usernotes set notecontent='"+notecontent+"' where noteid="+noteid+"";
            stmt.executeUpdate(s1);
            
          }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
       
           
