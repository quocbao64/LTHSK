package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CartItemDAO;
import entity.CartItem;
import service.CartItemService;

public class CartItemServiceImpl implements CartItemService {
	private CartItemDAO cartItemDAO;

	public CartItemServiceImpl(Connection con) {
		super();
		this.cartItemDAO = new CartItemDAO(con);
	}

	public void addCartItem(CartItem cartItem) {
		try {
			cartItemDAO.addCartItem(cartItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public CartItem searchCartItem(int ID) {
		try {
			return cartItemDAO.searchCartItem(ID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<CartItem> getListCartItem() {
		try {
			return cartItemDAO.getListCartItem();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CartItem> getListCartItemByOrderID(int ordersID) {
		try {
			return cartItemDAO.getListCartItemByOrderID(ordersID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delCartItem(int id){
		try {
			return cartItemDAO.delCartItem(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
