import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class login  extends HttpServlet 
{
	
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {
	 int j=0,c=0;

	 try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}

	 String email = req.getParameter("userEmail");  
	 String pwd = req.getParameter("userPass"); 
	
if(email!="")
{	
	try {
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");
		
    	
    	PreparedStatement select=con.prepareStatement("select username from userdetails where email = ?");
    	select.setString(1,email );
		ResultSet rs = select.executeQuery();
		
    	
		while(rs.next())
		{
			j=1;
  		}
		
		if(j==1)
		{

        	PreparedStatement select1=con.prepareStatement("select password,userid,username from userdetails where email = ?");
        	select1.setString(1,email);
        	ResultSet rs1 = select1.executeQuery();
        	rs1.next();
        	
			int userid = rs1.getInt("userid");
			
			String username=rs1.getString("username");


    		String checkpassword =rs1.getString("password");
    			if(pwd.equals(checkpassword))
    			{
    			  c=1;
				  req.getSession().setAttribute("username",username);
				  req.getSession().setAttribute("userid",userid);
				  System.out.println("username:"+username);
				  System.out.println("userid:"+userid);
    			  res.sendRedirect("otp.jsp");
    			}
		}
		else
		{
			//System.out.println("hi");
			res.sendRedirect("login.jsp");
		}
		
		if(c==0)
		{
			//System.out.println("hiii");
			res.sendRedirect("login.jsp");
		}
	
        }
	catch (SQLException e) {
		e.printStackTrace();
    }

}

else
{
     res.sendRedirect("login.jsp");
}
	 }
}
