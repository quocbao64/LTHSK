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
		try {
			usersDAO.addUsers(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Users searchUsers(int ID) {
		try {
			return usersDAO.searchUsers(ID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateUsers(Users users) {
		try {
			return usersDAO.updateUsers(users);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Users> getListUsers() {
		try {
			return usersDAO.getListUsers();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delUsers(int id){
		try {
			return usersDAO.delUsers(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Users searchUsersByGmail(String gmail) {
		try {
			return usersDAO.searchUsersByGmail(gmail);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
