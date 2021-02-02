package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartDao;
import com.app.pojos.Cart;
import com.app.pojos.CustomerAddress;
@Service
@Transactional
public class CartServiceImp implements ICartService {
	@Autowired
	ICartDao dao;
	@Override
	public String addToCart(int id,int user) {
		System.out.println("In service add to product ->2");

			String str=dao.addToCart(id,user);
			System.out.println("In servise add to  product ->3 "+ str);

		return str;
	}
	@Override
	public boolean removeFromCart(int id) {
		// TODO Auto-generated method stub
		return dao.removeFromCart(id);
	}
	@Override
	public List<Cart> getCart(int id) {
		// TODO Auto-generated method stub
		System.out.println("In getCart ->1 "+id);

		return dao.getCart(id);
	}
	@Override
	public
	List<CustomerAddress> getCustomerAddress(int id)
	{
		return dao.getCustomerAddress(id);
	}
	@Override
	public String processOrder(int customerId, String address, String cardNumber, String cardExpiry,
			String cardCVC, String cardHolderName) {
		
		return dao.processOrder(customerId,address,cardNumber,cardExpiry,cardCVC,cardHolderName);
		
	}

	
	
	
}
