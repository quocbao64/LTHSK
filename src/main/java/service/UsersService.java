package service;

import java.util.List;

import entity.Users;

public interface UsersService {
	public void addUsers(Users users);
	public Users searchUsers(int ID);
	public boolean updateUsers(Users users);
	public List<Users> getListUsers();
}
