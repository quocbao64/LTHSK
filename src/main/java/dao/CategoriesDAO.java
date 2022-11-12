package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Categories;

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
}
