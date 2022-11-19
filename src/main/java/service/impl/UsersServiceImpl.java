package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import dao.UsersDAO;
import entity.Users;
import gui.HomeAdmin_gui;
import service.UsersService;

public class UsersServiceImpl implements UsersService {
	private UsersDAO usersDAO;

	public UsersServiceImpl(Connection con) {
		super();
		this.usersDAO = new UsersDAO(con);
	}

	public void addUsers(Users users) throws Exception {
		usersDAO.addUsers(users);
	}

	public Users searchUsers(int ID) throws SQLException {
		return usersDAO.searchUsers(ID);
	}

	public boolean updateUsers(Users users) throws SQLException {
		return usersDAO.updateUsers(users);
	}

	public List<Users> getListUsers() throws SQLException {
		return usersDAO.getListUsers();
	}

	public boolean delUsers(int id) throws SQLException {
		return usersDAO.delUsers(id);
	}

	public Users searchUsersByGmail(String gmail) throws SQLException {
		return usersDAO.searchUsersByGmail(gmail);
	}

}
