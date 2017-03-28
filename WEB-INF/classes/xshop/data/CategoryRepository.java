package xshop.data;

import xshop.entity.Category;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryRepository {

    public boolean add(Category category) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Category(Name) VALUES(?)");
            stmt.setString(1, category.getName());

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

    public boolean edit(Category category) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("UPDATE Category SET Name=? WHERE Id=?");

            stmt.setString(1, category.getName());
            stmt.setInt(2, category.getId());

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

    public boolean remove(int categoryId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("delete from category where id=?");
            stmt.setInt(1, categoryId);

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

    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<Category>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT Id, Name FROM Category");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Category category = new Category(rs.getInt("Id"), rs.getString("Name"));
                categoryList.add(category);
            }
            con.close();

        } catch (Exception e) {

        }
        return categoryList;
    }

    public Category getById(int categoryId) {
        Category category = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT Id, Name FROM Category where id = "+categoryId );
            ResultSet rs = stmt.executeQuery();

            
            if (rs.next()) {
                category = new Category(rs.getInt("Id"), rs.getString("Name"));
            }
            con.close();

        } catch (Exception e) {

        }
        return category;
    }
}
