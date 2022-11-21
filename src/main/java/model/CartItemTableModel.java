package model;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.CartItem;
import entity.Order;
import entity.Product;

public class CartItemTableModel extends AbstractTableModel{

	private static final int STT = 0;
	private static final int NAME = 1;
	private static final int PRICE = 2;
	private static final int QUANTITY = 3;
	private static final int TOTALPRICE = 4;
	private List<CartItem> cartItems;
	private String[] headLine;

	
	public CartItemTableModel(List<CartItem> cartItems, String[] headLine) {
		super();
		this.cartItems = cartItems;
		this.headLine = headLine;
	}

	public int getRowCount() {
		return cartItems.size();
	}

	public int getColumnCount() {
		return headLine.length;
	}
	
	public String getColumnName(int column) {
		return headLine[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		CartItem c = cartItems.get(rowIndex);
		switch (columnIndex) {
		case STT:
			return rowIndex+1;
		case NAME:
			return c.getProduct().getName();
		case PRICE:
			return String.format("%,.0f", c.getProduct().getPrice()) + " ₫";
		case QUANTITY:
			return c.getQuantity();
		case TOTALPRICE:
			return String.format("%,.0f", Double.parseDouble(c.getProduct().getPrice().toString())*c.getQuantity()) + " ₫";
		default:
			break;
		}
		return null;
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex==NAME || STT==columnIndex) return String.class;
		return Integer.class;
	}
	
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}
