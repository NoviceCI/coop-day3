package coop.pratice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.pratice.dao.ProductImgDao;
import coop.pratice.domain.ProductImg;


@Service
@Scope("singleton")
@Transactional
public class ProductImgService {

	@Autowired
	ProductImgDao productImgDao ;

	public void addProductImg(ProductImg productImg){
		getProductImgDao().addProductImg(productImg);
	}
	
	public void updateProductImg(ProductImg productImg){
		getProductImgDao().updateProductImg(productImg);
	}
	
	public void deleteProductImg(ProductImg productImg){
		getProductImgDao().deleteProductImg(productImg);
	}
	
	
	
	
	public ProductImgDao getProductImgDao() {
		return productImgDao;
	}

	public void setProductImgDao(ProductImgDao productImgDao) {
		this.productImgDao = productImgDao;
	}
	
	
	
	
}
