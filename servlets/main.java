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


public class main extends HttpServlet
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	 {
    
        Connection con = null;
        Statement stmt = null;
        ResultSet rs1 = null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
       }catch(ClassNotFoundException e){
           e.printStackTrace();
       }
       
           
        Integer userid = (Integer) req.getSession().getAttribute("userid");
       // System.out.println(userid);
        String toSend="" ;

        try{
           con=DriverManager.getConnection("jdbc:mysql://localhost:2001/notesapp","renga","260701");
           stmt=con.createStatement();
           String sql ="select  *from usernotes where userid = "+userid+"";
           rs1 = stmt.executeQuery(sql);

          
           while(rs1.next())
          {
               String  name = rs1.getString("notename");
              //System.out.println(name);
               
               String  content = rs1.getString("notecontent");
              //System.out.println(content);

               int noteid = rs1.getInt("noteid");
              //System.out.println(""+noteid);
   
               toSend = toSend +  "<div style = 'width: 450px;height: 300px;margin: 40px;border: 3px solid;'><input type='text' name= 'notename' id='notename"+noteid+"' value='"+name+"' style='font-size:25px;position: relative;top: 0px;width:450px'><form action='option' method='post'><select style='position: relative;right: -296;top: -28;height:20;' name = 'option'><option value = 'deletenote`"+noteid+"'>Delete note</option> <option value = 'sharenote`"+noteid+"'>Share note</option></select> <input style='position: relative;right: -295;top: -27;'type='submit' value='submit'></form> <textarea name='notecontent' id='notecontent"+noteid+"' rows='6' cols='20' style='font-size:23px;position: relative;top: -38px;width:450px;height:266;'>"+content+"</textarea><input type='hidden' id='noteid"+noteid+"' name='noteId' value="+noteid+"><button value="+noteid+" style='font-size:15px;position: relative;top: -330px;right:-223px;width:70px;height:20px' onclick='editnote(this.value)'>Edit</button></div>";
          }

       }catch (SQLException e) {
            e.printStackTrace();
         //   System.out.println(e);
        }

      //  System.out.println(toSend);
        res.getWriter().write(toSend);
       
     }
}

