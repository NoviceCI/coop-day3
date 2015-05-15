package coop.pratice.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import coop.pratice.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<User> login(User user) {
		return getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from User u where u.username = :username and u.password = :password")
				.setParameter("username", user.getUsername())
				.setParameter("password", user.getPassword()).list();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getSessionFactory()
				.getCurrentSession()
				.createQuery("from User")
				.list();
	}

	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);

	}

	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);

	}

	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}
