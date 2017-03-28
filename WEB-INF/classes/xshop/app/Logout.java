package xshop.app;

import java.io.IOException;


import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie: cookies){
			
			cookie.setValue(null);
			//cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		response.sendRedirect("LoginServlet");
	}



}
