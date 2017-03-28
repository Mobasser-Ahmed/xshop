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


public class ChangePassServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form method='post'>");
		out.println("Current password :<br><input type='text' name='Currentpass' ><br>");
		out.println("New Password:<br><input type='password' name='pass' ><br>");
		out.println(" Confirm  new Password:<br><input type='password' name='cpass' ><br>");
	
		out.println("<input type='submit' value='Change'>");
		out.println("<a href='UserServlet'>Home</a>");
		out.println("</form> ");
		out.println("</body>");
		out.println("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id;
		String pass;
		System.out.println("change pass");
		HttpSession session= request.getSession();
		System.out.println("change pass id par holo");
		id= (String) session.getAttribute("id");
		System.out.println("change pass id te Assignment holo");
				
		String cpass= request.getParameter("cpass");
		//id= Integer.parseInt(id);
		pass=request.getParameter("Currentpass");
		PrintWriter out= response.getWriter();
		
		System.out.println("this is id :"+ id + " this is old pass: "+pass+"  this is new pass :"+ cpass);
		
		
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String password="";
		String query="Select * from user where ID='"+id+"' AND Pass='"+pass+"'";
		String pchange="UPDATE user SET Pass='"+cpass+"' WHERE ID='"+id+"'";
		
		
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, user, password);		
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);
			
			
			if(rs.next()==false){
				out.println("wrong ID and pass please try again ");
			}
			else {
				
				int cnt= st.executeUpdate(pchange);
			    if(cnt==1){
			    	out.print("password changed succesfuly");
			    	out.println("<a href='UserServlet'>Home</a>");
			    }
					
					
				}
			
			
			st.close();
			con.close();
		
	

			}
			catch (Exception e) {
				// TODO: handle exception
			}

	}

}
