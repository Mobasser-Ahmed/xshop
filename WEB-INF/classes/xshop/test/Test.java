package xshop.test;
import xshop.entity.Category;
import xshop.core.CategoryService;

public class Test{
	public static void main(String[] args){
            Category category = new Category("Tablet");
         
            CategoryService categoryService = new CategoryService();
            System.out.println(categoryService.add(category));
	}
}