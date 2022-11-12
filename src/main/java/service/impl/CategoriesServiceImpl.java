package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriesDAO;
import entity.Categories;
import service.CategoriesService;

public class CategoriesServiceImpl implements CategoriesService {
	private CategoriesDAO categoriesDAO;

	public CategoriesServiceImpl(Connection con) {
		super();
		this.categoriesDAO = new CategoriesDAO(con);
	}

	public void addCategories(Categories categories) {
		// TODO Auto-generated method stub
		try {
			categoriesDAO.addCategories(categories);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Categories searchCategories(int ID) {
		// TODO Auto-generated method stub
		try {
			return categoriesDAO.searchCategories(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Categories> getListCategories() {
		// TODO Auto-generated method stub
		try {
			return categoriesDAO.getListCategories();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
