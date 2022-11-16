package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriesDAO;
import entity.Categories;
import entity.Product;
import service.CategoriesService;

public class CategoriesServiceImpl implements CategoriesService {
	private CategoriesDAO categoriesDAO;

	public CategoriesServiceImpl(Connection con) {
		super();
		this.categoriesDAO = new CategoriesDAO(con);
	}

	public void addCategories(Categories categories) throws Exception {
		categoriesDAO.addCategories(categories);
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

	@Override
	public List<Product> getListProductNullCategories() {
		try {
			return categoriesDAO.getListProductNullCategories();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getListProductByCategoriesID(int id) {
		try {
			return categoriesDAO.getListProductByCategoriesID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean DelCategories(int id) {
		try {
			return categoriesDAO.DelCategories(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean UpdateCategories(Categories c) {
		try {
			return categoriesDAO.UpdateCategories(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

}
