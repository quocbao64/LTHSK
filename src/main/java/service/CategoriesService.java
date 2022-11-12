package service;

import java.util.List;

import entity.Categories;

public interface CategoriesService {
	public void addCategories(Categories categories);
	public Categories searchCategories(int ID);
	public List<Categories> getListCategories();
}
