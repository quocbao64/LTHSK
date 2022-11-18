package entity;

public class CartItem {
	private int ID;
	private int quantity;
	private Order order;
	private Product product;
	public CartItem(int iD, int quantity, Order order, Product product) {
		super();
		ID = iD;
		this.quantity = quantity;
		this.order = order;
		this.product = product;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	
}
