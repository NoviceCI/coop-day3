package coop.pratice.dao;

import java.util.List;

import coop.pratice.domain.User;

public interface UserDao {

	public List<User> login(User user);
	public List<User> getUsers();
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	
}
