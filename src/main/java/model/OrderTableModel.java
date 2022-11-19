package model;

import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;

import entity.Order;

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
			return new SimpleDateFormat("dd/MM/yyyy").format(Date.valueOf(o.getOrderDate()));
		case TOTALPRICE:
			return String.format("%,.0f", o.getTotalPrice()) + " ₫";
		case DISCOUNT:
			return String.format("%,.0f", o.getDiscount()) + " ₫";
		case USERNAME:
			return o.getUsers().getName();
		default:
			break;
		}
		return o.getID();
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(USERNAME==columnIndex || ID == columnIndex) return String.class;
		return Integer.class;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
