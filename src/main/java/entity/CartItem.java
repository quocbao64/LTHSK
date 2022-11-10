package entity;

public class CartItem {
	private int ID;
	private Product product;
	private int quantity;
	private Order order;

	public CartItem(int iD, int quantity, Order order, Product product) {
		super();
		ID = iD;
		this.product = product;
		this.quantity = quantity;
		this.order = order;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
