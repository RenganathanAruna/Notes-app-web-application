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

public class otpoption extends HttpServlet
{
 
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
       

        String option = req.getParameter("authentication");
        String d = "Google Authentication";
        if( d.equals(option))
        {
            res.sendRedirect("otp google.jsp");
        }
        else{
            res.sendRedirect("otp microsoft.jsp");
        }
           }
    
    
}

    
