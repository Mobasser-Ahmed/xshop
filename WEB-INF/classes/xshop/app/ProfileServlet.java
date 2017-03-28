package xshop.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProfileServlet extends HttpServlet {
	
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		HttpSession session= request.getSession();
		if(session==null){
			response.sendRedirect("LoginServlet");
		}
		else{
		String id= (String) session.getAttribute("id");
		//id= Integer.parseInt(id);
		
		PrintWriter out= response.getWriter();
		out.println("<h1>profile</h1>");
		
		
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String password="";
		String query="Select * from user where ID='"+id+"'";
		
		
		
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, user, password);		
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);
			
			
		
			if(rs.next()) {
				
				String typ=rs.getString("Type");
				String sname=rs.getString("Name");
				
				out.println("ID: "+id);
				out.println("<br>Name: "+sname);
				out.println("<br>User type: "+typ);
				
				
				
				
			}
			
			st.close();
			con.close();
		
	

			}
			catch (Exception e) {
				// TODO: handle exception
			}
	
			out.println("<br><a href='UserServlet'>GoHome</a>");
	}
	}


}
