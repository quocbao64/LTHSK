package service;

import java.util.List;

import entity.CartItem;

public interface CartItemService {
	public void addCartItem(CartItem cartItem);
	public CartItem searchCartItem(int ID);
	public List<CartItem> getListCartItem();
}
