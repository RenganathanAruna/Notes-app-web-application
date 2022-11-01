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


public class searchcontent extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {

        String search=(String)req.getParameter("Snotename");
       // System.out.println(search);

        req.getSession().setAttribute("searchnotename",search);

        res.sendRedirect("searchnote.jsp");

     }
}
    