package xshop.entity;

import java.util.List;
import java.util.ArrayList;

public class Category{
    final int id;
    String name;
    List<Product> products = new ArrayList<Product>();
    
    public Category(String name) {
	     this.id = 0;
        this.name = name;
    }
    
    public Category(int id, String name) {
	this.id = id;
	this.name = name;
    }
    
    public Category(int id, String name, List<Product> products) {
	     this.id = id;
        this.name = name;
	     this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProduct(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}