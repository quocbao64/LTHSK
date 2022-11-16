package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.SuppliersDAO;
import entity.Suppliers;
import service.SuppliersService;

public class SuppliersServiceImpl implements SuppliersService {
	private SuppliersDAO suppliersDAO;

	public SuppliersServiceImpl(Connection con) {
		super();
		this.suppliersDAO = new SuppliersDAO(con);
	}

	public void addSuppliers(Suppliers suppliers) {
		// TODO Auto-generated method stub
		try {
			suppliersDAO.addSuppliers(suppliers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Suppliers searchSuppliers(int ID) {
		// TODO Auto-generated method stub
		try {
			return suppliersDAO.searchSuppliers(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Suppliers> getListSuppliers(){
		try {
			return suppliersDAO.getListSuppliers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
