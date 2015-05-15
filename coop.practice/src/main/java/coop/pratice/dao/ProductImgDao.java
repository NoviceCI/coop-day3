package coop.pratice.dao;

import java.util.List;

import coop.pratice.domain.Product;
import coop.pratice.domain.ProductImg;

public interface ProductImgDao {

	
	public ProductImg getProductImg (ProductImg productImg);
	
	public List<ProductImg> getProductImgByProduct(Product product);
	
	public void deleteProductImg(ProductImg productImg);
	
	public void updateProductImg(ProductImg productImg);
	
	public void addProductImg(ProductImg productImg);
	
}
