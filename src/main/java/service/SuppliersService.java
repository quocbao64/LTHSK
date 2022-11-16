package service;

import java.util.List;

import entity.Suppliers;

public interface SuppliersService {
	public void addSuppliers(Suppliers suppliers);
	public Suppliers searchSuppliers(int ID);
	public List<Suppliers> getListSuppliers();
}
