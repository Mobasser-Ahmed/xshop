package xshop.core;

import xshop.entity.Product;
import xshop.data.ProductRepository;
import java.util.List;

public class ProductService{
	ProductRepository repository;
	
	public ProductService(){
		repository = new ProductRepository();
	}
	
    public boolean add(Product product){
        return repository.add(product);
    }
    
    public boolean edit(Product product){
        return repository.edit(product);
    }
    
    public boolean remove(int productId){
        return repository.remove(productId);
    }
    
    public List<Product> getAll(){
        return repository.getAll();
    }   
    
    public Product getById(int productId){
        return repository.getById(productId);
    }
}