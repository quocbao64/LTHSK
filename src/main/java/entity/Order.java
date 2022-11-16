package entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {
	private int ID;
	private LocalDate orderDate;
	private BigDecimal totalPrice;
	private double discount;
	private Users users;
	public Order(int iD, LocalDate orderDate, BigDecimal totalPrice, double discount, Users users) {
		super();
		ID = iD;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.users = users;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id) {
		this.ID=id;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	

}
