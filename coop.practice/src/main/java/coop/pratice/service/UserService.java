package coop.pratice.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.pratice.dao.UserDao;
import coop.pratice.domain.User;


@Service
@Scope("singleton")
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao ;

	public void updateUser(User user){
		getUserDao().updateUser(user);
	}
	
	public void deleteUser(User user){
		getUserDao().deleteUser(user);
	}
	
	public void addUser(User user){
		getUserDao().addUser(user);
	}
	
	public User login(User user){
		
		
		List<User> resultLogin = getUserDao().login(user);
		
		if (resultLogin.size() > 0) {
			
			return resultLogin.get(0);
		}
		else{
			
			User notLogin = new User();
			notLogin.setId(-1);
			notLogin.setName("UserNotLogin");
			return notLogin;
			
		}
		
	}
	
	public List<User> getUsers(){
		return getUserDao().getUsers();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
