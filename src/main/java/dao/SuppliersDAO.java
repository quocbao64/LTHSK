package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Categories;
import entity.Suppliers;

public class SuppliersDAO {
    private Connection con;

    public SuppliersDAO(Connection con) {
        this.con = con;
    }

    public void addSuppliers(Suppliers suppliers) throws Exception {
        if (searchSuppliers(suppliers.getID()) == null) {
            String sql = "Insert into [dbo].[Suppliers]([ID],[Name],[Gmail],[Phone],[Address]) values (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, suppliers.getID());
            stmt.setString(2, suppliers.getName());
            stmt.setString(3, suppliers.getGmail());
            stmt.setString(4, suppliers.getPhone());
            stmt.setString(5, suppliers.getAddress());

            stmt.executeUpdate();
        } else {
            throw new Exception("Trung ma");
        }
    }

    public Suppliers searchSuppliers(int ID) throws SQLException {
        String sql = "select * from Suppliers where ID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, ID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Suppliers suppliers = new Suppliers(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Gmail"),
                    rs.getString("Phone"),
                    rs.getString("Address"));
            return suppliers;
        }
        return null;
    }
    
    public List<Suppliers> getListSuppliers() throws SQLException {
    	String sql = "select * from Suppliers";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Suppliers> listSuppliers = new ArrayList<Suppliers>();
        while (rs.next()) {
        	Suppliers suppliers = new Suppliers(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Gmail"),
        			rs.getString("Phone"),
        			rs.getString("Address")
        			);
            listSuppliers.add(suppliers);
        }
        return listSuppliers;
    }
    
}
