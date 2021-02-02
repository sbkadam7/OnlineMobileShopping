package com.app.dao;

import java.util.List;

import com.app.pojos.Product;
import com.app.pojos.Seller;

public interface IProductDao {
	String addProduct(Product transientProduct,Seller s);
	
	public List<Product> getProductDetail();
	public Product getProductByID(int id);
	List<Product> searchProduct(String search);

}
