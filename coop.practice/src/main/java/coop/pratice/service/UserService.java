package coop.pratice.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.pratice.dao.UserDao;
import coop.pratice.domain.User;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao ;

	
	
	
	
	
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
