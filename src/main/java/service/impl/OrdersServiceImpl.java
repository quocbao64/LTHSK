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
		try {
			ordersDAO.addOrders(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Order searchOrder(int ID) {
		// TODO Auto-generated method stub
		try {
			return ordersDAO.searchOrder(ID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<Order> getListOrders() {
		try {
			return ordersDAO.getListOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delOrder(int id){
		
		try {
			return ordersDAO.delOrder(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateOrder(Order order){
		try {
			return ordersDAO.updateOrder(order);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
