package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISellerDao;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;
import com.app.pojos.Product;
import com.app.pojos.Seller;
import com.app.pojos.SellerAddress;
@Service
@Transactional
public class SellerService implements ISellerService {
	@Autowired
	private ISellerDao dao;
	@Override
	public String addSeller(Seller transientProduct) {
		return dao.addSeller(transientProduct);
	}
	@Override
	public Seller authenticateSeller(String email, String pwd) {
		System.out.println("in service : auth seller");
		return dao.authenticateSeller(email, pwd);
	}
	@Override
	public String addSellerAddress(SellerAddress transientProduct) {
		return dao.addSellerAddress(transientProduct);
	}
	@Override
	public String updateSellerProfile(Seller transientProduct) {
		// TODO Auto-generated method stub
		return dao.updateSellerProfile(transientProduct);
	}
	
	
	@Override
	public List<SellerAddress> getSellerAddress(int id) {
		// TODO Auto-generated method stub
		return dao.getSellerAddress(id);
	}
	@Override
	public List<Product> getSellerProduct(int id)
	{
		return dao.getSellerProduct(id);
	}
	@Override
	public List<Ordertable> getOrderDeatils(int sellerId) {
		// TODO Auto-generated method stub
		return dao.getOrderDetails(sellerId);
	}
}
