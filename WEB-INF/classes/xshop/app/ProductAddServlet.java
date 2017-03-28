package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Product;
import xshop.core.ProductService;

public class ProductAddServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  PrintWriter out = resp.getWriter();
		  out.println("<html>");
		  out.println("<body>");
		  out.println("<form method='post'>");

		  out.println("Product Name:<br/><input name='name' /><br/>");
		  out.println("Product stock:<br/><input name='stock' /><br/>");
		  out.println("Product buying_Price:<br/><input name='buying_Price' /><br/>");
		  out.println("Product Selling_price:<br/><input name='Selling_price' /><br/>");

		  out.println("Product Status");
		  out.println("<select>");
		  out.println("<option value='true'>true</option>");
		  out.println("  <option value='false'>false</option>");
		  out.println("</select>");
		  out.println("<br/>");
		  
		  out.println("Product category_id:<br/><input name='category_id' /><br/>");
		  out.println("Product supplier_id:<br/><input name='supplier_id' /><br/>");

		  out.println("<input type='submit' value='Save'/>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
		  out.println("<a href='list-product'>Show Product List</a>");
	  }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Product product = new Product(req.getParameter("name"),Integer.parseInt(req.getParameter("stock")),Float.parseFloat(req.getParameter("buying_Price")),Float.parseFloat(req.getParameter("Selling_price")),Boolean.parseBoolean(req.getParameter("status")),Integer.parseInt(req.getParameter("category_id")),Integer.parseInt(req.getParameter("supplier_id")));  
                new ProductService().add(product);
                resp.sendRedirect("list-product"); 
	  }

}