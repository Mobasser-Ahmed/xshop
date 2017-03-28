package xshop.entity;

import java.util.List;

public  class Supplier{
    int id;
    String name;
    String contact;
   // List<Product> products;
	
	//Implement Yourself

	public Supplier(){

	}

	public Supplier(String name, String contact){
		this.name = name;
		this.contact = contact;
	}
	public Supplier(int id, String name, String contact){
		this.id = id;
		this.name = name;
		this.contact = contact;
	}

	/*public Supplier(String name, String contact,  List<Product> products){
		this.name = name;
		this.contact = contact;
		this.products = products;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
/*
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}*/

	public int getId() {
		return id;
	}

}