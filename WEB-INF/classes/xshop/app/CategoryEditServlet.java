package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Category;
import xshop.core.CategoryService;

public class CategoryEditServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
      
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Category</h1>"); 
        out.println("<a href='add-category'>Add a category</a>"); 
        String cid=request.getParameter("id");  
        int id=Integer.parseInt(cid);  
          
        CategoryService ct=new CategoryService();
        Category ctedit= ct.getById(id);
        System.out.println(ctedit);
          
        out.print("<form  method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+ctedit.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+ctedit.getName()+"'/></td></tr>");  
         
        out.print("</td></tr>");  

        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
       
          
         
}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Category category = new Category(Integer.parseInt(req.getParameter("id")),req.getParameter("name"));  
      
        new CategoryService().edit(category);
        resp.sendRedirect("list-category"); 
        
      }


}