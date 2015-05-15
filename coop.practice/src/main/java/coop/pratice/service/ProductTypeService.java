package coop.pratice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.pratice.dao.ProductTypeDao;
import coop.pratice.domain.Producttype;

@Service
@Transactional
public class ProductTypeService {

	@Autowired
	private ProductTypeDao productTypeDao;

	public void addProductType(Producttype producttype) {
		getProductTypeDao().addProductType(producttype);
	}

	public void updateProductType(Producttype producttype){
		getProductTypeDao().updateProductType(producttype);
	}
	
	public void deleteProductType(Producttype producttype){
		getProductTypeDao().deleteProductType(producttype);
	}
	
	public List<Producttype> getProducttypes(){
		return getProductTypeDao().getProductTypes();
		
	}
	
	
	public ProductTypeDao getProductTypeDao() {
		return productTypeDao;
	}

	public void setProductTypeDao(ProductTypeDao productTypeDao) {
		this.productTypeDao = productTypeDao;
	}

}
