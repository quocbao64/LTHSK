package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.CartItem;
import entity.Order;

public class OrdersDAO {
	private Connection con;
	private static UsersDAO usersDAO;

	public OrdersDAO(Connection con) {
		this.con = con;
		usersDAO = new UsersDAO(con);
	}

	public void addOrders(Order order) throws Exception {
		if (searchOrder(order.getID()) == null) {
			String sql = "Insert into [dbo].[Orders]([ID],[OrderDate],[TotalPrice],[DisCount],[UsersID]) values (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, order.getID());
			stmt.setDate(2, Date.valueOf(order.getOrderDate()));
			stmt.setBigDecimal(3, order.getTotalPrice());
			stmt.setDouble(4, order.getDiscount());
			stmt.setInt(5, order.getUsers().getID());

			stmt.executeUpdate();
		} else {
			throw new Exception("Trung ma");
		}
	}

	public Order searchOrder(int ID) throws SQLException {
		String sql = "select * from Orders where ID = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
//
//        String sql2 = "select ci.ProductID"
//                + "from Orders od inner join CartItem ci on od.ID = ci.OrdersID"
//                + "where od.ID = ?";
//        PreparedStatement stmt2 = con.prepareStatement(sql2);
//        stmt2.setInt(1, ID);
//        ResultSet rs2 = stmt2.executeQuery();
//        List<CartItem> listCart = new ArrayList<CartItem>();

//        while (rs2.next()) {
//        	CartItemDAO cartItemDAO = new CartItemDAO(con);
//            CartItem cartItem = cartItemDAO.searchCartItem(ID);
//            if (cartItem != null)
//                listCart.add(cartItem);
//        }
		while (rs.next()) {
			Order order = new Order(rs.getInt("ID"), LocalDate.parse(rs.getDate("OrderDate").toString()),
					rs.getBigDecimal("TotalPrice"), rs.getDouble("DisCount"),
					usersDAO.searchUsers(rs.getInt("UsersID")));
			return order;
		}
		return null;
	}

	public boolean updateOrder(Order order) throws SQLException {
		String sql = "UPDATE [dbo].[Orders] " + "   SET [OrderDate] = ? " + "      ,[TotalPrice] = ? "
				+ "      ,[DisCount] = ? " + "      ,[UsersID] = ?" + " WHERE  ID = ?";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setDate(1, Date.valueOf(order.getOrderDate()));
		stmt.setBigDecimal(2, order.getTotalPrice());
		stmt.setDouble(3, order.getDiscount());
		stmt.setInt(4, order.getUsers().getID());
		stmt.setInt(5, order.getID());
		int n = stmt.executeUpdate();

		return n > 0;
	}

	public boolean delOrder(int id) throws SQLException {
		String sql = "delete Orders where ID = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		int n = stmt.executeUpdate();
		return n > 0;
	}

	public List<Order> getListOrders() throws SQLException {
		List<Order> listOrders = new ArrayList<Order>();
		String sql = "Select * from Orders";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Order order = new Order(rs.getInt("ID"), rs.getDate("OrderDate").toLocalDate(),
					rs.getBigDecimal("TotalPrice"), rs.getDouble("DisCount"),
					usersDAO.searchUsers(rs.getInt("UsersID")));
			listOrders.add(order);
		}

		return listOrders;
	}
}
