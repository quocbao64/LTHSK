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
    private static OrdersDAO ordersDAO;
    private static ProductDAO productDAO;

    public CartItemDAO(Connection con) {
        this.con = con;
    }

    public void addCartItem(CartItem cartItem) throws Exception {
        if (searchCartItem(cartItem.getID()) == null) {
            String sql = "Insert into [dbo].[CartItem]([ID],[Quantity],[OrdersID],[ProductID]) values (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cartItem.getID());
            stmt.setInt(2, cartItem.getQuantity());
            stmt.setInt(4, cartItem.getOrder().getID());
            stmt.setInt(5, cartItem.getProduct().getID());

            stmt.executeUpdate();
        } else {
            throw new Exception("Trung ma");
        }
    }

    public CartItem searchCartItem(int ID) throws SQLException {
        String sql = "select * from Product where ID = ?";
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

    // public boolean updateProduct(Product product) throws SQLException {
    // if (searchProduct(product.getID()) == null) {
    // String sql = "update Product set Name = ?, Price = ?, SuppliersID = ?,
    // CategoriesID = ?";
    // PreparedStatement stmt = con.prepareStatement(sql);
    // stmt.setString(1, product.getName());
    // stmt.setBigDecimal(2, product.getPrice());
    // stmt.setInt(3, product.getSuppliers().getID());
    // stmt.setInt(4, product.getCategories().getID());
    // stmt.executeUpdate();
    // return true;
    // }
    // return false;
    // }

    public List<CartItem> getListProducts() throws SQLException {
        List<CartItem> listCartItem = new ArrayList<CartItem>();
        String sql = "Select * from Product";
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
}
