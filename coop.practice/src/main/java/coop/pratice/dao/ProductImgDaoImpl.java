package coop.pratice.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import coop.pratice.domain.Product;
import coop.pratice.domain.ProductImg;

@Repository
public class ProductImgDaoImpl implements ProductImgDao {

	
	@Autowired
	private SessionFactory sessionFactory ;
	
	
	
	public ProductImg getProductImg(ProductImg productImg) {
		return (ProductImg) getSessionFactory()
				.getCurrentSession()
				.createQuery("from ProductImg where id=:id")
				.setParameter("id",productImg.getId())
				.list()
				.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<ProductImg> getProductImgByProduct(Product product) {
		return getSessionFactory()
				.getCurrentSession()
				.createQuery("from ProductImg where product_id = :pid")
				.setParameter("pid",product.getId())
				.list();
	}
	


	public void deleteProductImg(ProductImg productImg) {
		getSessionFactory().getCurrentSession().delete(productImg);
		
	}

	public void updateProductImg(ProductImg productImg) {
		getSessionFactory().getCurrentSession().update(productImg);
		
	}

	public void addProductImg(ProductImg productImg) {
		getSessionFactory().getCurrentSession().update(productImg);
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
