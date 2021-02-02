package com.app.dao;
import java.util.List;

import com.app.pojos.Ordertable;
import com.app.pojos.Product;
import com.app.pojos.Seller;
import com.app.pojos.SellerAddress;

public interface ISellerDao {
	String addSeller(Seller transientProduct);
	Seller authenticateSeller(String email1, String pwd1);
	String addSellerAddress(SellerAddress transientProduct);
	String updateSellerProfile(Seller transientProduct);
	List<SellerAddress> getSellerAddress(int id);
	List<Product> getSellerProduct(int id);
	List<Ordertable> getOrderDetails(int sellerId);
}
