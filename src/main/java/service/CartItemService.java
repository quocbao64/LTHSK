package service;

import java.sql.SQLException;
import java.util.List;

import entity.CartItem;

public interface CartItemService {
	public void addCartItem(CartItem cartItem);
	public CartItem searchCartItem(int ID);
	public List<CartItem> getListCartItem();
	public List<CartItem> getListCartItemByOrderID(int ordersID) throws SQLException;
}
