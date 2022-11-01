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



public class searchnote extends HttpServlet
{
	
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {
		
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
		int i=0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			//System.out.println(e);
		}

		int userid = (int) req.getSession().getAttribute("userid");
	//	System.out.println(userid);
        String search=(String)req.getSession().getAttribute("searchnotename");
	//	System.out.println(search);
		String username = (String) req.getSession().getAttribute("username");
		String toSend="";
		String name="";
		
  
try{
		if(search!="")
		{
		con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");
		stmt=con.createStatement();
		String sql= "select *from usernotes where notename like '%"+search+"%'";
		rs = stmt.executeQuery(sql);		
	  
		while(rs.next())
        {
			System.out.println("hi");
			i=1;
            int id=rs.getInt("userid");
    			if(id==userid)
    			{

					  name = rs.getString("notename");
					  System.out.println(name);
					  
					  String  content = rs.getString("notecontent");
					  System.out.println(content);
		  

                   toSend = toSend  + "<div style ='position: relative;width: 350;height: 200px;margin: 40px;border: 2px solid;'><h2 style='font-size:25px;border: 1px solid;position: relative;top: -22;'>"+name+"</h2><p style='font-size:23px;position: relative;top: -36;'>"+content+"</p></div>";
                }
        }

	    }    
		else
		{
		  toSend = "<h1>Empty search result!!!</h1>";
		}

		if(name=="")
		{
		  toSend = "<h1>No result found!!!</h1>";
		}


	}catch (SQLException e) {
		e.printStackTrace();
	//	System.out.println(e);
	}

res.getWriter().write(toSend);
//System.out.println(toSend);



       }
}