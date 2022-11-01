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


public class sharenote extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {
      
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
         

        int j=0;
        String sendername = (String)req.getSession().getAttribute("username");
        String receivername=(String)req.getParameter("receivername");  
	    String sharednoteid=(String)req.getSession().getAttribute("worknoteid"); 
       // int userid = (int) req.getSession().getAttribute("userid");


        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");

            Statement stmt = con.createStatement();
            String sql= "select username from userdetails";
            ResultSet rs1 = stmt.executeQuery(sql);

            while(rs1.next())
            {
                String  checkname = rs1.getString("username");
                   // System.out.println("  "+checkname);
    			  if(checkname.equals(receivername) && receivername!=sendername)
    			  {
                     j=1;
                  }
            }

            if(j==1)
            {
            Statement stmt1 = con.createStatement();
            String sql1= "insert into usersharednotes values('"+sendername+"','"+receivername+"',"+sharednoteid+");";
                     stmt1.executeUpdate(sql1);
                     res.sendRedirect("main.jsp");
            // String sql1= "select *from usernotes where userid = "+userid+"";
            // ResultSet rs2 = stmt1.executeQuery(sql1);
 
            //  while( rs2.next())
    		//  {
  	    	//       String checkname = rs2.getString("notename");
            //       //  System.out.println(checkname);
    		// 	  if(checkname.equals(sharednote))
    		// 	  {
    				
    		// 		   String notecontent =rs2.getString("notecontent");
            //         System.out.println(notecontent);

            //         Statement stmt2 = con.createStatement();
            //         String sql2= "insert into usersharednotes values('"+sendername+"','"+receivername+"','"+sharednoteid+"');";
            //         stmt1.executeUpdate(sql2);
            //         j=1;
            //         res.sendRedirect("main.jsp");
            //       }
            //  }
           }

            if(j==0)
            {
            res.sendRedirect("main.jsp");
            }


        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
     }
}
