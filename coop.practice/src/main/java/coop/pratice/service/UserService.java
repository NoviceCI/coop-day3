package coop.pratice.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.pratice.domain.User;


@Component
public class UserService {
	
	@Autowired
	SessionFactory sessionFactory ;

	
	@Transactional
	public User login (User user){
		
		
		User loginUser = new User();
		
		List<User>  result = getSessionFactory().getCurrentSession()
				.createQuery("from User u where u.username = :u and u.password = :p")
				.setParameter("u", loginUser.getUsername())
				.setParameter("p",loginUser.getPassword())
				.list();
		
		if (result.size() > 0) {
			
			loginUser = result.get(0);
			
		}
		
		else{
			
			loginUser.setId(-1);
		}
		
		return loginUser;
				
		
	}
	
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
