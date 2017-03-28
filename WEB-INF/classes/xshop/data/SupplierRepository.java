package xshop.data;

import xshop.entity.Supplier;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SupplierRepository {


    public SupplierRepository() {
    }

    public boolean add(Supplier supplier) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Supplier(Name,contact) VALUES(?,?)");
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getContact());

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



    public boolean edit(Supplier supplier) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("UPDATE Supplier SET Name=? , contact=? WHERE Id=?");
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getContact());
            stmt.setInt(3, supplier.getId());

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




    public Supplier getById(int supplierId) {
        Supplier supplier = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT Id, Name, Contact FROM Supplier WHERE id ="+supplierId);
            ResultSet rs = stmt.executeQuery();

            
            if (rs.next()) {
                supplier = new Supplier(rs.getInt("Id"), rs.getString("name"), rs.getString("contact"));
            }
            con.close();

        } catch (Exception e) {

        }
        return supplier;
    }





    public List<Supplier> getAll() {
        List<Supplier> supplierList = new ArrayList<Supplier>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT Id, Name , Contact FROM supplier");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Supplier supplier = new Supplier(rs.getInt("Id"), rs.getString("Name") , rs.getString("Contact"));
                supplierList.add(supplier);
            }
            con.close();

        } catch (Exception e) {

        }
        return supplierList;
    }




    public boolean remove(int supplierId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xshopdb", "root", "");

            PreparedStatement stmt = con.prepareStatement("DELETE from supplier WHERE id=?");
            stmt.setInt(1, supplierId);
            int result = stmt.executeUpdate();
            con.close();

            System.out.println(result);

            if (result != 0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
    }


}