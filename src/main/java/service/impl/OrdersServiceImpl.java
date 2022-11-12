package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.OrdersDAO;
import entity.Order;
import service.OrdersService;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDAO ordersDAO;
	
	public OrdersServiceImpl(Connection con) {
		super();
		this.ordersDAO = new OrdersDAO(con);
	}

	public void addOrders(Order order) {
		// TODO Auto-generated method stub
		try {
			ordersDAO.addOrders(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Order searchOrder(int ID) {
		// TODO Auto-generated method stub
		try {
			return ordersDAO.searchOrder(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Order> getListOrders() {
		// TODO Auto-generated method stub
		try {
			return ordersDAO.getListOrders();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
