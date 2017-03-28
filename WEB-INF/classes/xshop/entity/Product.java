package xshop.entity;



public class Product{
    int id=0;
    String name;
    int stock;
    double buyingPrice;
    double sellingPrice;
    boolean status; 
    int categoryId;
    int supplierId;
    
    //Implement Yourself
    
    
    
    public Product() {
        
        
    }
    
    public Product( int id, int stock, double buyingPrice, double sellingPrice, boolean status) {
        this.id=id;
       
        this.stock = stock;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.status = status;
        
    }
    
    
    
    public Product(String name, int stock, double buyingPrice, double sellingPrice, boolean status,int categoryId, int supplierId) {
        this.id=0;
        this.name = name;
        this.stock = stock;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.status = status;
        this.categoryId=categoryId;
        this.supplierId=supplierId;
    }
        
       
        
        
    public Product(int id, String name, int stock, double buyingPrice, double sellingPrice, boolean status) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.status = status;
    }
      
    public Product(int id, String name, int stock, double buyingPrice, double sellingPrice, boolean status,int categoryId, int supplierId) {
        this.id=id;
        this.name = name;
        this.stock = stock;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.status = status;
        this.categoryId=categoryId;
        this.supplierId=supplierId;
    }   


    public Product(int id, String name, int stock, double buyingPrice, double sellingPrice, int categoryId, int supplierId) {
        this.id=id;
        this.name = name;
        this.stock = stock;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        //this.status = status;
        this.categoryId=categoryId;
        this.supplierId=supplierId;
    }     
        
      
        
        
        
        
    public void setName(String name) {
        this.name = name;
    }

    public void setStock(short stock) {
        this.stock = stock;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public boolean isStatus() {
        return status;
    }
    
    
    public int getCategoryId() {
        return categoryId;
    }
    
    public int getSupplierId() {
        return supplierId;
    }
   
        
        
        
        
}