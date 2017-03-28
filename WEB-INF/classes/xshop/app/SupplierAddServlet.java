package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Supplier;
import xshop.core.SupplierService;

public class SupplierAddServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
		  out.println("<a href='list-supplier'>Show ALL Supplier</a>");
		  out.println("<form method='post'>");
		  out.println("Supplier Name:<br/><input name='name' /><br/>");
		  out.println("Supplier Contact:<br/><input name='contact' /><br/>");
		  out.println("<input type='submit' value='Save'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Supplier supplier = new Supplier(req.getParameter("name"), req.getParameter("contact"));  
                System.out.println(new SupplierService().add(supplier));
        resp.sendRedirect("list-supplier");
	  }
}