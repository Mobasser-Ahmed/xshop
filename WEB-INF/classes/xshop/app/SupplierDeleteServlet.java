package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Supplier;
import xshop.core.SupplierService;

public class SupplierDeleteServlet extends HttpServlet{
	private int s_id;
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	  		s_id = Integer.parseInt(req.getParameter("id"));
	  		Supplier supplier = new SupplierService().getById(s_id);


		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
out.println("<a href='list-supplier'>Show ALL</a>");
out.println("<a href='add-supplier'>Add New</a>");

		  out.println("<form method='post'>");
		  out.println("Supplier Id:<br/><input name='s_id' readonly value="+s_id+" /><br/>");
		  out.println("Name:<br/><input name='s_name' readonly value="+supplier.getName()+"  /><br/>");
		  out.println("Contact:<br/><input name='s_Contact' readonly value="+supplier.getContact()+"  /><br/><br/>");
		  out.println("<input type='submit' value='Confirm Delete'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
                System.out.println(new SupplierService().remove(s_id));

                resp.sendRedirect("list-supplier");
	  }
}