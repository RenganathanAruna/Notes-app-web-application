import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.*;
import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.*;
import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class register extends HttpServlet {

	private Connection con = null;

	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {

		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println(e);
		}
		 
		 String username = req.getParameter("userName");
		 String phoneno = req.getParameter("phoneno");
		 String dob = req.getParameter("dob");
         String email = req.getParameter("email");
		 String pwd=req.getParameter("userPass");  
		 
		 int j=0;
		 

	SecureRandom random = new SecureRandom();
    byte[] bytes = new byte[20];
    random.nextBytes(bytes);
    Base32 base32 = new Base32();
    String securecode = base32.encodeToString(bytes);
   // System.out.println(securecode);

	SecureRandom randomm = new SecureRandom();
    byte[] bytess = new byte[20];
    random.nextBytes(bytess);
    Base32 base321 = new Base32();
    String securecodee = base321.encodeToString(bytess);
   // System.out.println(securecodee);


if(username!="")
{
		 try {
	        
			con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");
			
        	PreparedStatement pstmt=con.prepareStatement("insert into userdetails values(userid,?,?,?,?,?,?,?);");
        	pstmt.setString(1,username);
			pstmt.setString(2,phoneno);
			pstmt.setString(3,dob);
			pstmt.setString(4,email);
        	pstmt.setString(5,pwd);
			pstmt.setString(6,securecode);
			pstmt.setString(7,securecodee);
        	pstmt.executeUpdate();
        	
    		
			pstmt.close();
    		con.close();
			req.getSession().setAttribute("reg",username);
			res.sendRedirect("displaykey.jsp");
			
    		
    		}catch (SQLException e) 
        	{
				e.printStackTrace();
				System.out.println(e);
            }
	}
	else
	{
		res.sendRedirect("Register.jsp");
	}

	 }
}

