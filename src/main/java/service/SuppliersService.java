package service;

import entity.Suppliers;

public interface SuppliersService {
	public void addSuppliers(Suppliers suppliers);
	public Suppliers searchSuppliers(int ID);
}
