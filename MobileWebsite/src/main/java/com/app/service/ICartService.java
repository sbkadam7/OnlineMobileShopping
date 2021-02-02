package com.app.service;

import java.util.List;

import com.app.pojos.Cart;
import com.app.pojos.CustomerAddress;

public interface ICartService {

	String addToCart(int id,int user);
	boolean removeFromCart(int id);
	List<Cart> getCart(int id);
	List<CustomerAddress> getCustomerAddress(int id);
	String processOrder(int customerId,String address, String cardNumber, String cardExpiry, String cardCVC,
			String cardHolderName);
}
