package com.app.service;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;

public interface ICustomerService {

	String addCustomer(Customer transientProduct);
	Customer authenticateUser(String email, String pwd);
	String addCustomerAddress(CustomerAddress transientProduct);
	String updateCustomerProfile(Customer transientProduct);
	public List<CustomerAddress> getCustomerAddress(int id);
	List<Ordertable> getOrderDeatils(int customerId);

}
