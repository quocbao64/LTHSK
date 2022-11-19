package service;

import java.sql.SQLException;
import java.util.List;

import entity.Users;

public interface UsersService {
	public void addUsers(Users users) throws Exception;
	public Users searchUsers(int ID) throws SQLException;
	public boolean updateUsers(Users users) throws SQLException;
	public List<Users> getListUsers() throws SQLException;
	public boolean delUsers(int id) throws SQLException;
	public Users searchUsersByGmail(String gmail) throws SQLException;
}
