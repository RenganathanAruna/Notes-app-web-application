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


public class deletenote extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {

		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

        int j=0;
        String deletenote=(String)req.getSession().getAttribute("worknoteid");
        int userid = (int) req.getSession().getAttribute("userid");
        System.out.println(deletenote);
       // System.out.println(userid);

        try {   
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");
            Statement stmt = con.createStatement();

            String sql = "delete from usernotes where noteid = "+deletenote+"";
            stmt.executeUpdate(sql);

            String sql1 = "delete from usersharednotes where noteid = "+deletenote+"";
            stmt.executeUpdate(sql1);
            res.sendRedirect("main.jsp");


        //     String sql= "select *from usernotes where userid = "+userid+"";
        //     ResultSet rs1 = stmt.executeQuery(sql);

    		
  	    //    while( rs1.next())
    		// {
  	    // 	      String  checknamedelete = rs1.getString("notename");
        //           //  System.out.println(checknamedelete);
    		// 	  if(checknamedelete.equals(deletenote))
    		// 	  {
    				
    		// 		String  content =rs1.getString("notecontent");
        //           //  System.out.println(content);


        //             Statement stmt1 = con.createStatement();
        //             String sql1 = "delete from usernotes where notecontent = '"+content+"'";
        //             stmt1.executeUpdate(sql1);

        //             Statement stmt2 = con.createStatement();
        //             String sql2 = "delete from usersharednotes where notecontent = '"+content+"'";
        //             stmt2.executeUpdate(sql2);
                    
        //             j=1;
        //             res.sendRedirect("main.jsp");

        //           }
                  
        //     }
        //     if(j==0)
        //     {
        //     res.sendRedirect("main.jsp");
        //     }

        }catch (SQLException e) {
            e.printStackTrace();
          //  System.out.println(e);
        }

    }
}

