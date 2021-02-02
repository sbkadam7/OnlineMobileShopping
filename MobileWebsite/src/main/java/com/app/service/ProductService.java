package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.pojos.Product;
import com.app.pojos.Seller;

//spring bean : SC
@Service
@Transactional
public class ProductService implements IProductService {
	//dependency : dao i/f
	@Autowired
	private IProductDao dao;


	


	@Override
	public String addProduct(Product transientProduct,Seller s) {
		return dao.addProduct(transientProduct,s);
	}





	@Override
	public List<Product> getProductDetail() {
		
		return dao.getProductDetail();
	}
	
	public Product getProductByID(int id) {
		return dao.getProductByID(id);
	}





	@Override
	public List<Product> searchProduct(String search) {
		// TODO Auto-generated method stub
		return dao.searchProduct(search);
	}
	
}
