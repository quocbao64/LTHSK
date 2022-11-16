package service;

import java.util.List;

import entity.Categories;
import entity.Product;

public interface CategoriesService {
	public void addCategories(Categories categories) throws Exception;
	public Categories searchCategories(int ID);
	public List<Categories> getListCategories();
    public List<Product> getListProductNullCategories();
    public List<Product> getListProductByCategoriesID(int id);
    public boolean DelCategories(int id);
    public boolean UpdateCategories(Categories c);
    
}
