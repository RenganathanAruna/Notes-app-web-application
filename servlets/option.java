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

public class option extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {
        String opt = req.getParameter("option");
        String a = "deletenote";
        System.out.println(opt);

        String[] arrOfStr = opt.split("`", 2);
        
        String option = arrOfStr[0];
       // System.out.println(option);
        String noteid = arrOfStr[1];
        System.out.println(noteid);
        req.getSession().setAttribute("worknoteid",noteid);



        if( a.equals(option))
        {
           res.sendRedirect("deletenote");
        }
        else{
            res.sendRedirect("sharenote.jsp");
        }
    }
}
