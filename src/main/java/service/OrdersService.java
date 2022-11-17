package service;

import java.sql.SQLException;
import java.util.List;

import entity.Order;

public interface OrdersService {
	public void addOrders(Order order);
	public Order searchOrder(int ID);
	public boolean delOrder(int id) throws SQLException ;
	public boolean updateOrder(Order order) throws SQLException;
	public List<Order> getListOrders();
}
