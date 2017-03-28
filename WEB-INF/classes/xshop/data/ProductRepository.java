package xshop.data;

import xshop.entity.Product;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepository {

    public boolean add(Product product ) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

           
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Product(Name,stock,buying_price,selling_price,status,category_id,supplier_id) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStock());
            stmt.setDouble(3, product.getBuyingPrice());
            stmt.setDouble(4, product.getSellingPrice());
            stmt.setBoolean(5, true);
            stmt.setInt(6, product.getCategoryId());
            stmt.setInt(7, product.getSupplierId());

            System.out.println(product.getName());

            int result = stmt.executeUpdate();
            con.close();
            
            if (result != 0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean edit(Product product) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("UPDATE product SET Name=?, stock=?,buying_price=?,selling_price=?, status=?,category_id=?, supplier_id=? WHERE Id=?");

            stmt.setString(1,  product.getName());
             stmt.setInt(2, product.getStock());
            stmt.setDouble(3, product.getBuyingPrice());
            stmt.setDouble(4, product.getSellingPrice());
            stmt.setBoolean(5, product.isStatus());
            stmt.setInt(6, product.getCategoryId());
            stmt.setInt(7, product.getSupplierId());
            stmt.setInt(8, product.getId());

            int result = stmt.executeUpdate();
            con.close();

            if (result != 0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(int productId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("delete from Product where id=?");
            stmt.setInt(1, productId);

            int result = stmt.executeUpdate();
            con.close();

            if (result != 0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Product> getAll() {
        List<Product> productList = new ArrayList<Product>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT *  FROM Product");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getInt("Id"), rs.getString("Name"),rs.getInt("stock"),rs.getDouble("buying_price"),rs.getDouble("selling_price"),rs.getBoolean("status"),rs.getInt("category_id"),rs.getInt("supplier_id"));
                productList.add(product);
            }
            con.close();

        } catch (Exception e) {

        }
        return productList;
    }

    public Product getById(int productId) {
        Product product = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT Id, Name, stock,buying_price,selling_price,status,category_id,supplier_id FROM Product where id = "+productId );
            ResultSet rs = stmt.executeQuery();

            System.out.println(productId);
            if (rs.next()) {
              

                int p_id = rs.getInt("Id");
                String p_name = rs.getString("Name");
                int p_stock = rs.getInt("stock");
                double p_bp = rs.getDouble("buying_price");
                double p_sp = rs.getDouble("selling_price");

                boolean p_status = rs.getBoolean("status");
                System.out.println("paise1");
                int c_id = rs.getInt("category_id");
                System.out.println("paise2");
                int s_id = rs.getInt("supplier_id");
                System.out.println("paise3");
                


System.out.println("id="+p_id+ " nam="+p_name+ " stock="+p_stock+ " bp="+p_bp+ " sp="+p_sp+ " sts="+p_status+ " cid="+c_id+ " sid="+s_id);
                product = new Product(p_id,p_name,p_stock,p_bp,p_sp,p_status,c_id,s_id);
                System.out.println("done");


            }
            con.close();

        } catch (Exception e) {

        }
        return product;
    }
}
