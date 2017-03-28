package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Product;
import xshop.core.ProductService;

public class ProductEditServlet extends HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
      
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Product</h1>"); 
        out.println("<a href='product-add'>Add product</a>"); 
        String cid=request.getParameter("id");  
        int id=Integer.parseInt(cid);  
         
        ProductService ct=new ProductService();
        Product ptedit= ct.getById(id);

        

        out.print("<form  method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+ptedit.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ptedit.getName()+"'/></td></tr>");  
        out.print("<tr><td>Stock:</td><td><input type='text' name='stock' value='"+ptedit.getStock()+"'/></td></tr>");
        out.print("<tr><td>Buying Price:</td><td><input type='text' name='buying_Price' value='"+ptedit.getBuyingPrice()+"'/></td></tr>");
        out.print("<tr><td>Selling Price:</td><td><input type='text' name='selling_price' value='"+ptedit.getSellingPrice()+"'/></td></tr>");
        out.print("<tr><td>Status:</td><td><input type='text' name='status' value='"+ptedit.isStatus()+"'/></td></tr>");
        out.print("<tr><td>Category:</td><td><input type='text' name='category_id' value='"+ptedit.getCategoryId()+"'/></td></tr>");
        out.print("<tr><td>Supplier:</td><td><input type='text' name='supplier_id' value='"+ptedit.getSupplierId()+"'/></td></tr>");

        out.print("</td></tr>");  

        out.print("<tr><td colspan='2'><input type='submit' value='Confirm Edit'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
       
          
         
}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Product product =  new Product(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),Integer.parseInt(req.getParameter("stock")),Float.parseFloat(req.getParameter("buying_Price")),Float.parseFloat(req.getParameter("selling_price")),Boolean.parseBoolean(req.getParameter("status")),Integer.parseInt(req.getParameter("category_id")),Integer.parseInt(req.getParameter("supplier_id")));  
      
        new ProductService().edit(product);
        resp.sendRedirect("list-product"); 
        
      }


}