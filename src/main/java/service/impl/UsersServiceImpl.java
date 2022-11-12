package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.UsersDAO;
import entity.Users;
import service.UsersService;

public class UsersServiceImpl implements UsersService {
	private UsersDAO usersDAO;

	public UsersServiceImpl(Connection con) {
		super();
		this.usersDAO = new UsersDAO(con);
	}

	public void addUsers(Users users) {
		// TODO Auto-generated method stub
		try {
			usersDAO.addUsers(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Users searchUsers(int ID) {
		// TODO Auto-generated method stub
		try {
			return usersDAO.searchUsers(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateUsers(Users users) {
		// TODO Auto-generated method stub
		try {
			return usersDAO.updateUsers(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Users> getListUsers() {
		// TODO Auto-generated method stub
		try {
			return usersDAO.getListUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
