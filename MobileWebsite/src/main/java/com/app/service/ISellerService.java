package com.app.service;

import java.util.List;

import com.app.pojos.Ordertable;
import com.app.pojos.Product;
import com.app.pojos.Seller;
import com.app.pojos.SellerAddress;

public interface ISellerService {

	String addSeller(Seller transientProduct);
	Seller authenticateSeller(String email, String pwd);
	String addSellerAddress(SellerAddress transientProduct);
	
	String updateSellerProfile(Seller transientProduct);
	List<SellerAddress> getSellerAddress(int id);
	List<Product> getSellerProduct(int id);
	List<Ordertable> getOrderDeatils(int sellerId);
}
