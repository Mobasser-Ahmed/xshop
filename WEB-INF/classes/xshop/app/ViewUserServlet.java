package xshop.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class ViewUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
	
		HttpSession session = request.getSession();
		if(session == null ){
			response.sendRedirect("LoginServlet");
		}
		else{
		
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String password="";
		
		
		String naam = request.getParameter("username");
		
		String chabi = request.getParameter("password");
		
		String sql="Select * from user";
		try {
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
		 
			
			
			
	
		out.println("<html>");
		out.println("<body>");
		
		out.println("<table border='2'>");
		out.println(" <tr>");
		out.println("<th>ID</th>");
		out.println("<th>NAME</th>");
		out.println("<th>Pass</th>");
		out.println("<th>Type</th>");
		out.println("</tr>");
		  
		while(rs.next()){
		
		
		out.println("<tr>");
		out.println("<td>"+rs.getString("ID")+"</td>");
		out.println("<td>"+rs.getString("Name")+"</td>");
		out.println("<td>"+rs.getString("Pass")+"</td>");
		out.println("<td>"+rs.getString("Type")+"</td>");
		
		
		
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		st.close();
		con.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<br><a href='UserServlet'>GoHome</a>");
		}
		
	}

	

}
