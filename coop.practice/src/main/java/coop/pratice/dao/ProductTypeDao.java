package coop.pratice.dao;

import java.util.List;
import coop.pratice.domain.Producttype;


public interface ProductTypeDao {

	public void addProductType(Producttype producttype);
	public void updateProductType(Producttype producttype);
	public void deleteProductType(Producttype producttype);
	public List<Producttype> getProductTypes();
	
}
