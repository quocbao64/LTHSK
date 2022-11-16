package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProductDAO;
import entity.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	
	public ProductServiceImpl(Connection con) {
		super();
		this.productDAO = new ProductDAO(con);
	}

	public void addProduct(Product product) throws Exception{
		productDAO.addProduct(product);
	}

	public Product searchProduct(int ID) {
		// TODO Auto-generated method stub
		try {
			return productDAO.searchProduct(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			return productDAO.updateProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public List<Product> getListProducts() {
		// TODO Auto-generated method stub
		try {
			return productDAO.getListProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean DelProduct(int id) {
		try {
			return productDAO.DelProduct(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

}
