package service;

import java.util.List;

import entity.Product;

public interface ProductService {
	public void addProduct(Product product);
	public Product searchProduct(int ID);
	public boolean updateProduct(Product product);
	public List<Product> getListProducts();
}
