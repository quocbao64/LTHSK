package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.Users;

public class UsersDAO {
	private Connection con;

	public UsersDAO(Connection con) {
		this.con = con;
	}

	public void addUsers(Users user) throws Exception {
		if (searchUsers(user.getID()) == null) {
			String sql = "Insert into [dbo].[Users]([ID],[Name],[Gender],[Gmail],[Phone],[Address],[BirthDate],[HireDate],[Role],[Password]) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, user.getID());
			stmt.setString(2, user.getName());
			stmt.setInt(3, user.isGender());
			stmt.setString(4, user.getGmail());
			stmt.setString(5, user.getPhone());
			stmt.setString(6, user.getAddress());
			stmt.setDate(7, Date.valueOf(user.getBirthDate()));
			stmt.setDate(8, Date.valueOf(user.getHireDate()));
			stmt.setString(9, user.getRole());
			stmt.setString(10, user.getPassword());

			stmt.executeUpdate();
		} else {
			throw new Exception("Trung ma");
		}
	}

	public Users searchUsers(int ID) throws SQLException {
		String sql = "select * from Users where ID = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Users user = new Users(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Gender"), rs.getString("Gmail"),
					rs.getString("Phone"), rs.getString("Address"), LocalDate.parse(rs.getDate("BirthDate").toString()),
					LocalDate.parse(rs.getDate("HireDate").toString()), rs.getString("Role"), rs.getString("Password"));
			return user;
		}
		return null;
	}
	
	public Users searchUsersByGmail(String gmail) throws SQLException {
		String sql = "select * from Users where Gmail = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, gmail);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Users user = new Users(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Gender"), rs.getString("Gmail"),
					rs.getString("Phone"), rs.getString("Address"), LocalDate.parse(rs.getDate("BirthDate").toString()),
					LocalDate.parse(rs.getDate("HireDate").toString()), rs.getString("Role"), rs.getString("Password"));
			return user;
		}
		return null;
	}

	public boolean delUsers(int id) throws SQLException {
		String sql = "delete Users where ID = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		int n = stmt.executeUpdate();
		return n > 0;
	}

	public boolean updateUsers(Users user) throws SQLException {
		String sql = "update Users set Name = ?, Gender = ?, Gmail = ?, Phone = ?, Address = ?, BirthDate = ?, HireDate = ?, Role = ?, Password = ? where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setInt(2, user.isGender());
		stmt.setString(3, user.getGmail());
		stmt.setString(4, user.getPhone());
		stmt.setString(5, user.getAddress());
		stmt.setDate(6, Date.valueOf(user.getBirthDate()));
		stmt.setDate(7, Date.valueOf(user.getHireDate()));
		stmt.setString(8, user.getRole());
		stmt.setString(9, user.getPassword());
		stmt.setInt(10, user.getID());
		int n = stmt.executeUpdate();
		return n > 0;
	}

	public List<Users> getListUsers() throws SQLException {
		List<Users> listUsers = new ArrayList<Users>();
		String sql = "Select * from Users";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Users user = new Users(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Gender"), rs.getString("Gmail"),
					rs.getString("Phone"), rs.getString("Address"), LocalDate.parse(rs.getDate("BirthDate").toString()),
					LocalDate.parse(rs.getDate("HireDate").toString()), rs.getString("Role"), rs.getString("Password"));
			listUsers.add(user);
		}

		return listUsers;
	}
}
