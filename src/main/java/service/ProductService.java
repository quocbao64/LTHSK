package service;

import java.sql.SQLException;
import java.util.List;

import entity.Product;

public interface ProductService {
	public void addProduct(Product product) throws Exception;
	public Product searchProduct(int ID);
	public boolean updateProduct(Product product);
	public List<Product> getListProducts();
	public boolean DelProduct(int id) throws SQLException;
}
