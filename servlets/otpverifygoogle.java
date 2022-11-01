import java.security.*;
import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.*;
import java.io.*;

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

public class otpverifygoogle extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {
    
        try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

        int userid = (int) req.getSession().getAttribute("userid");
        String otp = req.getParameter("otpG");
       // System.out.println(otp);

        try {   
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");
            Statement stmt = con.createStatement();
            String sql= "select authenticationG from userdetails where userid = "+userid+"";
            ResultSet rs1 = stmt.executeQuery(sql);

        rs1.next();
        String securecode = rs1.getString("authenticationG");
       
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(securecode);
        String hexKey = Hex.encodeHexString(bytes);
        String code = TOTP.getOTP(hexKey);


        if(code.equals(otp))
        {
            res.sendRedirect("main.jsp");
        }
        else
        {
            res.sendRedirect("otp.jsp");
        }

    }catch (SQLException e) {
        e.printStackTrace();
        System.out.println(e);
    }
    }
}