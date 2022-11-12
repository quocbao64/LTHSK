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
		// TODO Auto-generated method stub
		try {
			cartItemDAO.addCartItem(cartItem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public CartItem searchCartItem(int ID) {
		// TODO Auto-generated method stub
		try {
			return cartItemDAO.searchCartItem(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<CartItem> getListCartItem() {
		// TODO Auto-generated method stub
		try {
			return cartItemDAO.getListCartItem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
