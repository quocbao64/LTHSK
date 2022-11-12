package service;

import java.util.List;

import entity.Order;

public interface OrdersService {
	public void addOrders(Order order);
	public Order searchOrder(int ID);
	public List<Order> getListOrders();
}
