package xshop.app;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import xshop.entity.Category;
import xshop.core.CategoryService;

public class CategoryDeleteServlet extends HttpServlet{
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String cid=request.getParameter("id");  
        int id=Integer.parseInt(cid);  
        CategoryService cs= new CategoryService();
        cs.remove(id);  
        response.sendRedirect("list-category");  
    }  
}