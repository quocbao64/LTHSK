package entity;

import java.math.BigDecimal;

public class Product {
	private int ID;
	private String name;
	private BigDecimal price;
	private Suppliers suppliers;
	private Categories categories;
	public Product(int iD, String name, BigDecimal price, Suppliers suppliers, Categories categories) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.suppliers = suppliers;
		this.categories = categories;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Suppliers getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	

}
