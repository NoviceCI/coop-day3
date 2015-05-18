package coop.pratice.beans;

import java.util.HashMap;
import java.util.List;
import java.io.Serializable;

import org.hibernate.event.spi.ClearEvent;
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

	private HashMap<String, Integer> hashProductType;
	
	

	public List<Producttype> producttypes;

	public void setProducttypes(List<Producttype> producttypes) {
		this.producttypes = producttypes;
	}

	private Producttype producttype = new Producttype();

	public String addProductType() {
		getProductTypeService().addProductType(producttype);
		setProducttype(new Producttype());
		
		return "list1";

	}

	public String updateProductType() {
		getProductTypeService().updateProductType(getProducttype());
		setProducttype(null);
		return "list";
	}

	public String goToEditPage(Producttype producttype) {
		setProducttype(producttype);
		return "editpage";

	}

	public String goToAddPage() {
		setProducttype(producttype);
		return "addpage";

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

	public void clear(Producttype producttype) {
		producttype.setName("");
	}

	public HashMap<String, Integer> getHashProductType() {
		
		hashProductType = new HashMap<String, Integer>();
		
		List<Producttype> listProductType = getProductTypeService().getProducttypes();
		
		for (Producttype item : listProductType) {
			
			hashProductType.put(item.getName(),item.getId());
		}
		return hashProductType;
		
	}
	
	
}
