package xshop.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminServlet extends HttpServlet {
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession(false); 
		
		if(session==null){
			response.sendRedirect("LoginServlet");
		}
		else {
		
		
		
		String type=(String) session.getAttribute("type");
		
		String uname=(String)session.getAttribute("name");
	
		
		
		if(type.equals("admin")){
			out.println("<html>");
			out.println("Welcome :"+uname );
			
			out.println("<br><a href='ProfileServlet'>Profile</a><br>");
			out.println("<a href='ChangePassServlet'>Chage password</a><br>");
			out.println("<a href='ViewUserServlet'>View User</a><br>");
			out.println("<a href='Logout'>Logout</a><br>");
			
			out.println("</html>");
		}
		else if(type.equals("user")){
			response.sendRedirect("UserServlet");
		}
		else {
			response.sendRedirect("LoginServlet");
		}
		
		}
		
		
	}
	

}
