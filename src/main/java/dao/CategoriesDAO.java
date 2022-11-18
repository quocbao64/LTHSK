package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Categories;
import entity.Product;

public class CategoriesDAO {
    private Connection con;

    public CategoriesDAO(Connection con) {
        this.con = con;
    }

    public void addCategories(Categories categories) throws Exception {
        if (searchCategories(categories.getID()) == null) {
            String sql = "Insert into [dbo].[Categories]([ID],[Name]) values (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, categories.getID());
            stmt.setString(2, categories.getName());

            stmt.executeUpdate();
        } else {
            throw new Exception("Trung ma");
        }
    }

    public Categories searchCategories(int ID) throws SQLException {
        String sql = "select * from Categories where ID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, ID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Categories categories = new Categories(
                    rs.getInt("ID"),
                    rs.getString("Name"));
            return categories;
        }
        return null;
    }
    
    public List<Categories> getListCategories() throws SQLException {
    	String sql = "select * from Categories";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Categories> listCategories = new ArrayList<Categories>();
        while (rs.next()) {
            Categories categories = new Categories(
                    rs.getInt("ID"),
                    rs.getString("Name"));
            listCategories.add(categories);
        }
        return listCategories;
    }
    
    public List<Product> getListProductNullCategories() throws SQLException {
    	ProductDAO productDAO = new ProductDAO(con);
        return productDAO.getListProducts();
    }
    
    public List<Product> getListProductByCategoriesID(int id) throws SQLException {
    	SuppliersDAO suppliersDAO = new SuppliersDAO(con);
    	List<Product> listProduct = new ArrayList<Product>();
        String sql = "Select * from Product where CategoriesID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Product product = new Product(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getBigDecimal("Price"),
                    suppliersDAO.searchSuppliers(rs.getInt("SuppliersID")),
                    searchCategories(id)
                    );
            listProduct.add(product);
        }
    	return listProduct;
    }
    public boolean DelCategories(int id) throws SQLException {
    	String sql = "DELETE FROM [dbo].[Categories] "
    			+ " WHERE ID = ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        int n = stmt.executeUpdate();
        
        return n>0;
    }
    public boolean UpdateCategories(Categories c) throws SQLException {
    	String sql = "UPDATE [dbo].[Categories] "
    			+ "   SET [Name] = ?"
    			+ " WHERE ID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, c.getName());
        stmt.setInt(2, c.getID());
        int n = stmt.executeUpdate();
        return n>0;
    }
}
