package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDAO {
	private Connection con;
	private static SuppliersDAO suppliersDAO;
	private static CategoriesDAO categoriesDAO;

	public ProductDAO(Connection con) {
		this.con = con;
		suppliersDAO = new SuppliersDAO(con);
		categoriesDAO = new CategoriesDAO(con);
	}

	public void addProduct(Product product) throws Exception {
		if (searchProduct(product.getID()) == null) {
			String sql = "Insert into [dbo].[Product]([ID],[Name],[Price],[SuppliersID],[CategoriesID]) values (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, product.getID());
			stmt.setString(2, product.getName());
			stmt.setBigDecimal(3, product.getPrice());
			stmt.setInt(4, product.getSuppliers().getID());
			stmt.setInt(5, product.getCategories().getID());

			stmt.executeUpdate();
		} else {
			throw new Exception("Trung ma");
		}
	}

	public Product searchProduct(int ID) throws SQLException {
		String sql = "select * from Product where ID = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Product product = new Product(rs.getInt("ID"), rs.getString("Name"), rs.getBigDecimal("Price"),
					suppliersDAO.searchSuppliers(rs.getInt("SuppliersID")),
					categoriesDAO.searchCategories(rs.getInt("CategoriesID")));
			return product;
		}
		return null;
	}

	public boolean DelProduct(int id) throws SQLException {
		String sql = "DELETE FROM [dbo].[Product] " + " WHERE ID = ? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		int n = stmt.executeUpdate();

		return n > 0;
	}

	public boolean updateProduct(Product product) throws SQLException {

		String sql = "update Product set Name = ?, Price = ?, SuppliersID = ?, CategoriesID = ? WHERE ID = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, product.getName());
		stmt.setBigDecimal(2, product.getPrice());
		stmt.setInt(3, product.getSuppliers().getID());
		stmt.setInt(4, product.getCategories().getID());
		stmt.setInt(5, product.getID());
		int n = stmt.executeUpdate();
		return n > 0;

	}

	public List<Product> getListProducts() throws SQLException {
		List<Product> listProduct = new ArrayList<Product>();
		String sql = "Select * from Product";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Product product = new Product(rs.getInt("ID"), rs.getString("Name"), rs.getBigDecimal("Price"),
					suppliersDAO.searchSuppliers(rs.getInt("SuppliersID")),
					categoriesDAO.searchCategories(rs.getInt("CategoriesID")));
			listProduct.add(product);
		}

		return listProduct;
	}
}
