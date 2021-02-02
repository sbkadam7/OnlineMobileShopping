package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;

public interface ICustomerDao {
	String addProduct(Customer transientProduct);
	Customer authenticateUser(String email1, String pwd1);
	String addCustomerAddress(CustomerAddress transientProduct);
	String updateCustomerProfile(Customer transientProduct);
	public List<CustomerAddress> getCustomerAddress(int id);
	List<Ordertable> getOrderDetails(int customerId);

}
