package xshop.app;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;


public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Cookie[] ck = request.getCookies();
		String userId = null;
		
	    System.out.println("this is cookie: "+ ck);
		
		if (ck != null && ck.length > 2) {

			for (Cookie cookie : ck) {
				System.out.println("here is cookie index name---: "+ cookie.getName());
				if ("id".equals(cookie.getName())) {
					
					userId = cookie.getValue();
					System.out.println("here is id: "+ userId);
					try{
					if(session==null){
					 session = request.getSession();
					session.setAttribute("id",userId);
					}
					}
					catch(Exception e){
						System.out.println("excetion ");
					}
				}
				if ("type".equals(cookie.getName())) {
					
					
					
					try{
					if(session==null)
					 session = request.getSession();
					session.setAttribute("type",cookie.getValue());
					System.out.println("this is session dget type: "+session.getAttribute("type"));
					
					}
					catch(Exception e){
						System.out.println("excetion ");
					}
				}
				if ("name".equals(cookie.getName())) {
					
					
					try{
					if(session==null)
					 session = request.getSession();
					session.setAttribute("name",cookie.getValue());
					
					}
					catch(Exception e){
						System.out.println("excetion ");
					}	
					
				}
				
			
				}

			System.out.println("this is cook: " + userId);
			System.out.println("this is sess: " + session);
		}
		
		System.out.println("this is session before null: " + session);
        
		if (session == null ) {
            
			PrintWriter out = response.getWriter();
			out.println(
					"<html><body><form method='post'>User ID:<br><input type='text' name='ID' ><br>Password:<br><input type='password' name='pass' ><br>");
			out.println(
					"<input type='checkbox' name='remember' value='remember'>Remember me<br><input type='submit' value='Login'><a href='RegisterServlet'>Register</a></form>");
			out.println("</body</html>");
		}
		// else if(session==null && !ck[0].getValue().equals(null)) {
		else {
			System.out.println("logged in");
			response.sendRedirect("UserServlet");
			}
			
			
			
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("ID");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		String remember ="";
		request.getParameter("remember");
		System.out.println("this is reme: "+ remember);

		PrintWriter out = response.getWriter();

		String url = "jdbc:mysql://localhost:3306/login";
		String user = "root";
		String password = "";
		String query = "Select * from user where ID='" + id + "' AND Pass='" + pass + "'";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next() == false) {
				out.println("wrong uname and pass please try again ");
			} else {

				String typ = rs.getString("Type");
				String sname = rs.getString("Name");

				System.out.println("this is database: " + typ);
				/// --------session setting up------------////
				session.setAttribute("name", sname);
				session.setAttribute("id", id);
				session.setAttribute("type", typ);
				System.out.println("this is session from post: "+session.getAttribute("type"));
				System.out.println("this is typ: "+typ );

				/// -----cookie setting up----////

				if (remember!=null) {
					System.out.println("remebr cookie ");
					Cookie Cid = new Cookie("id", id);// creating cookie object
					Cookie Ctype = new Cookie("type", typ);
					Cookie Cname = new Cookie("name", sname);
					Cid.setMaxAge(10000);
					
					Ctype.setMaxAge(10000);
					
					Cname.setMaxAge(10000);
					response.addCookie(Cid);
					response.addCookie(Ctype);
					response.addCookie(Cname);
					
					System.out.println("cookie set holo");
				}
				
				
			///----test---///
				
				System.out.println("login servlet array sr");
			    
				
				
				
				
				
				
				
				
				if (typ.equals("admin")) {
					System.out.println("admin page a jabe akn");
					
					response.sendRedirect("AdminServlet");
				} 
				else if (typ.equals("user")){
					response.sendRedirect("UserServlet");
				}
				System.out.println("this is typ2: "+typ );
			}

			st.close();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
