package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;
import com.app.pojos.Seller;

//spring bean : SC
@Service
@Transactional
public class CustomerService implements ICustomerService {
	//dependency : dao i/f
	@Autowired
	private ICustomerDao dao;

	

	@Override
	public String addCustomer(Customer transientProduct) {
		return dao.addProduct(transientProduct);
	}
	@Override
	public Customer authenticateUser(String email, String pwd) {
		System.out.println("in service : auth customer");
		return dao.authenticateUser(email, pwd);
	}
	@Override
	public String addCustomerAddress(CustomerAddress transientProduct) {
		return dao.addCustomerAddress(transientProduct);
	}
	
	@Override
	public String updateCustomerProfile(Customer transientProduct) {
		// TODO Auto-generated method stub
		return dao.updateCustomerProfile(transientProduct);
	}
	@Override
	public List<CustomerAddress> getCustomerAddress(int id) {
		// TODO Auto-generated method stub
		return dao.getCustomerAddress(id);
	}
	@Override
	public List<Ordertable> getOrderDeatils(int customerId) {
		// TODO Auto-generated method stub
		return dao.getOrderDetails(customerId);
	}
}
