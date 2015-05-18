package coop.pratice.beans;

import java.util.List;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import coop.pratice.service.ProductTypeService;
import coop.pratice.domain.Producttype;
import coop.pratice.domain.User;

@Component
@Scope
public class ProductTypeBean implements Serializable {



	@Autowired
	private ProductTypeService productTypeService;

	public List<Producttype> producttypes   ;
	
	public void setProducttypes(List<Producttype> producttypes) {
		this.producttypes = producttypes;
	}

	private Producttype producttype = new Producttype();

	public void addProductType() {
		getProductTypeService().addProductType(producttype);
		setProducttype(null);
	}

	public void updateProductType() {
		getProductTypeService().updateProductType(getProducttype());
		setProducttype(null);
	}

	public void deleteProductType(Producttype producttype) {
		getProductTypeService().deleteProductType(producttype);
	}

	public List<Producttype> getProducttypes() {
	
		
		List<Producttype> list = getProductTypeService().getProducttypes();
		
		return list;
	}

	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	public Producttype getProducttype() {
		return producttype;
	}

	public void setProducttype(Producttype producttype) {
		this.producttype = producttype;
	}

}
