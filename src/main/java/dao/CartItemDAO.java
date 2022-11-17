package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CartItem;

public class CartItemDAO {
    private Connection con;
    private static ProductDAO productDAO;
    private static OrdersDAO ordersDAO;

    public CartItemDAO(Connection con) {
        this.con = con;
        ordersDAO = new OrdersDAO(con);
        productDAO = new ProductDAO(con);
    }

    public void addCartItem(CartItem cartItem) throws Exception {
        if (searchCartItem(cartItem.getID()) == null) {
            String sql = "Insert into [dbo].[CartItem]([ID],[Quantity],[OrdersID],[ProductID]) values (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cartItem.getID());
            stmt.setInt(2, cartItem.getQuantity());
            stmt.setInt(3, cartItem.getOrder().getID());
            stmt.setInt(4, cartItem.getProduct().getID());

            stmt.executeUpdate();
        } else {
            throw new Exception("Trùng mã");
        }
    }

    public CartItem searchCartItem(int ID) throws SQLException {
        String sql = "select * from CartItem where ID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, ID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CartItem cartItem = new CartItem(
                    rs.getInt("ID"),
                    rs.getInt("Quantity"),
                    ordersDAO.searchOrder(rs.getInt("OrdersID")),
                    productDAO.searchProduct(rs.getInt("ProductID")));
            return cartItem;
        }
        return null;
    }

    public boolean xoaNhanvien(String maNV) {

        return false;
    }

    public List<CartItem> getListCartItem() throws SQLException {
        List<CartItem> listCartItem = new ArrayList<CartItem>();
        String sql = "Select * from CartItem";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CartItem cartItem = new CartItem(
                    rs.getInt("ID"),
                    rs.getInt("Quantity"),
                    ordersDAO.searchOrder(rs.getInt("OrdersID")),
                    productDAO.searchProduct(rs.getInt("ProductID")));
            listCartItem.add(cartItem);
        }

        return listCartItem;
    }
    
    public List<CartItem> getListCartItemByOrderID(int ordersID) throws SQLException {
        List<CartItem> listCartItem = new ArrayList<CartItem>();
        String sql = "Select * from CartItem where OrdersID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, ordersID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CartItem cartItem = new CartItem(
                    rs.getInt("ID"),
                    rs.getInt("Quantity"),
                    ordersDAO.searchOrder(rs.getInt("OrdersID")),
                    productDAO.searchProduct(rs.getInt("ProductID")));
            listCartItem.add(cartItem);
        }

        return listCartItem;
    }
}
