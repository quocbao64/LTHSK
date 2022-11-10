package entity;

import java.math.BigDecimal;

public class Product {
	private int ID;
	private String name;
	private Suppliers suppliers;
	private Categories categories;
	private BigDecimal price;

	public Product(int iD, String name, Suppliers suppliers, Categories categories, BigDecimal price) {
		super();
		ID = iD;
		this.name = name;
		this.suppliers = suppliers;
		this.categories = categories;
		this.price = price;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
