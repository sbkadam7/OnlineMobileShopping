package com.app.service;

import java.util.List;

import com.app.pojos.Product;
import com.app.pojos.Seller;

public interface IProductService {

	String addProduct(Product transientProduct,Seller s);
	List<Product> getProductDetail();
	public Product getProductByID(int id);
	List<Product> searchProduct(String search);

}