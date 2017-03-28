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



public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.print("<center>");
		out.print("<table border='3'>");
		
		out.print("<tr>");
		out.print("<th>");
		out.print("Registration");
		out.print("</th>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td>");
		out.println("<form  method='post'>");
		out.println("ID:<br><input type='text' name='ID' ><br>");
		out.println("Password:<br><input type='password' name='pass' ><br>");
		out.println(" Confirm Password:<br><input type='password' name='cpass' ><br>");
		out.println(" Name:<br><input type='text' name='name' ><br>");
		out.println("User Type:<br>");
		out.println("<input type='radio' name='type' value='admin' checked> admin");
		
		out.println("<input type='radio' name='type' value='user'>user<br>");
		
		out.println("<input type='submit' value='Sign up'>");
		out.println("<a href='LoginServlet'>sign in</a>");
		out.println("</form> ");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id= request.getParameter("ID");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		String name=request.getParameter("name");
		String type=request.getParameter("type");
	
		PrintWriter out= response.getWriter();
		
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String password="";
		String query="Select * from user where ID='"+id+"'";
		String add="INSERT INTO user(ID,Pass, Name, Type) VALUES ('"+id+"','"+pass+"','"+name+"','"+type+"')";
		
			try {
			//2	
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, user, password);	
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);	
			if(rs.next()==true){
				out.println("this id is already used");
			}
			else if(!cpass.equals(pass)){
				out.println("passwords dont match");
			}
			else {
				int cn= st.executeUpdate(add);
				if(cn==1)
				 out.println("Registration successful");
				 response.sendRedirect("LoginServlet");
				    
				
			}
			st.close();
			con.close();
		
	

			}
			catch (Exception e) {
				// TODO: handle exception
			}
		
		
		
		
		
		
	}

}
