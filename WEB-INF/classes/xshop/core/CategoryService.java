package xshop.core;

import xshop.entity.Category;
import xshop.data.CategoryRepository;
import java.util.List;

public class CategoryService{
	CategoryRepository repository;
	
	public CategoryService(){
		repository = new CategoryRepository();
	}
	
    public boolean add(Category category){
        return repository.add(category);
    }
    
    public boolean edit(Category category){
        return repository.edit(category);
    }
    
    public boolean remove(int categoryId){
        return repository.remove(categoryId);
    }
    
    public List<Category> getAll(){
        return repository.getAll();
    }   
    
    public Category getById(int categoryId){
        return repository.getById(categoryId);
    }
}