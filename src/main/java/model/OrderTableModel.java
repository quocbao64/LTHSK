package model;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Order;
import entity.Product;

public class OrderTableModel extends AbstractTableModel{
	private static final int ID = 0;
	private static final int ORDERDATE = 1;
	private static final int TOTALPRICE = 2;
	private static final int DISCOUNT = 3;
	private static final int USERNAME = 4;
	private List<Order> orders;
	private String[] headLine;

	public OrderTableModel(List<Order> orders, String[] headLine) {
		super();
		this.orders = orders;
		this.headLine = headLine;
	}

	@Override
	public int getRowCount() {
		return orders.size();
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
		Order o = orders.get(rowIndex);
		switch (columnIndex) {
		case ID:
			return o.getID();
		case ORDERDATE:
			return o.getOrderDate();
		case TOTALPRICE:
			return o.getTotalPrice();
		case DISCOUNT:
			return o.getDiscount();
		case USERNAME:
			return o.getUsers().getName();
		default:
			break;
		}
		return o.getID();
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return Integer.class;
	}
	
	public void setProducts(List<Order> orders) {
		this.orders = orders;
	}
}
