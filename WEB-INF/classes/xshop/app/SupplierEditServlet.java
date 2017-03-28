package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Supplier;
import xshop.core.SupplierService;

public class SupplierEditServlet extends HttpServlet{
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
		  out.println("New Name:<br/><input name='s_name' value="+supplier.getName()+"  /><br/>");
		  out.println("New Contact:<br/><input name='s_Contact' value="+supplier.getContact()+"  /><br/>");
		  out.println("<input type='submit' value='Update'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
			Supplier supplier = new Supplier(s_id,req.getParameter("s_name"), req.getParameter("s_Contact"));
                System.out.println(new SupplierService().edit(supplier));
                System.out.println(supplier.getId());
                System.out.println(supplier.getName());
                System.out.println(supplier.getContact());

                resp.sendRedirect("list-supplier");
	  }
}