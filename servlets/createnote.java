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


public class createnote extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {

		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println(e);
		}

	      int userid = (int) req.getSession().getAttribute("userid");
		 // System.out.println(userid);

          String notename=(String)req.getParameter("notename");
		 // System.out.println(notename);

		  String notecontent=(String)req.getParameter("notecontent");
		 // System.out.println(notecontent);

      try {
	 
	    
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");

		Statement stmt = con.createStatement();
		String sql = "insert into usernotes values(noteid,'"+notename+"','"+notecontent+"',"+userid+");";
		stmt.executeUpdate(sql);
		res.sendRedirect("main.jsp");
		}

		catch (SQLException e) 
 	    {
          e.printStackTrace();
		  System.out.println(e);
        }
 
     }
}
