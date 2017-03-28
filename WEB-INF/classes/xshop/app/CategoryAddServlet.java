package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Category;
import xshop.core.CategoryService;

public class CategoryAddServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
		  out.println("<form method='post'>");
		  out.println("Category Name:<br/><input name='name' /><br/>");
		  out.println("<input type='submit' value='Save'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
		  out.println("<a href='list-category'>Show Product List</a>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Category category = new Category(req.getParameter("name"));  
                new CategoryService().add(category);
                resp.sendRedirect("list-category"); 
	  }

}