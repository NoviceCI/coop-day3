package coop.pratice.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import coop.pratice.domain.Producttype;

@Repository
public class ProductTypeDaoImpl implements ProductTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public void addProductType(Producttype producttype) {
		getSessionFactory().getCurrentSession().save(producttype);

	}

	@SuppressWarnings("unchecked")
	public void updateProductType(Producttype producttype) {
		getSessionFactory().getCurrentSession().update(producttype);

	}

	@SuppressWarnings("unchecked")
	public void deleteProductType(Producttype producttype) {
		getSessionFactory().getCurrentSession().delete(producttype);

	}

	@SuppressWarnings("unchecked")
	public List<Producttype> getProductTypes() {

		return getSessionFactory().getCurrentSession()
				.createQuery("from Producttype pt ORDER By pt.id ASC").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
