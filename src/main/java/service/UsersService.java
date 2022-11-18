package service;

import java.sql.SQLException;
import java.util.List;

import entity.Users;

public interface UsersService {
	public void addUsers(Users users);
	public Users searchUsers(int ID);
	public boolean updateUsers(Users users);
	public List<Users> getListUsers();
	public boolean delUsers(int id) throws SQLException;
	public Users searchUsersByGmail(String gmail) throws SQLException;
}
