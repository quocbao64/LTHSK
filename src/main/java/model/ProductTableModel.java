package model;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Product;

public class ProductTableModel extends AbstractTableModel{
	private static final int ID = 0;
	private static final int NAME = 1;
	private static final int SUPPLIERSID = 2;
	private static final int CATEGORYID = 3;
	private static final int PRICE = 4;
	private List<Product> products;
	private String[] headLine;
	
	
	public ProductTableModel(List<Product> products, String[] headLine) {
		super();
		this.products = products;
		this.headLine = headLine;
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {
		return headLine.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return headLine[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product p = products.get(rowIndex);
		switch (columnIndex) {
		case ID:
			return p.getID();
		case NAME:
			return p.getName();
		case SUPPLIERSID:
			return p.getSuppliers().getName();
		case CATEGORYID:
			return p.getCategories().getName();
		case PRICE:
			return String.format("%,.0f", p.getPrice()) + " ₫";
			
		default:
			break;
		}
		return p.getID();
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(NAME == columnIndex || ID == columnIndex) return String.class;
		return Integer.class;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
