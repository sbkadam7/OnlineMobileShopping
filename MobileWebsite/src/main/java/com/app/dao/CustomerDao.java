package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;
@Repository
public class CustomerDao implements ICustomerDao{
	@PersistenceContext //JPA anno.
	private EntityManager mgr;
	
	
	@Override
	public String addProduct(Customer transientProduct) {
		String mesg="Product added successfully";
		mgr.persist(transientProduct);
		return mesg;
	}
	@Override
	public Customer authenticateUser(String email1, String pwd1) {
		String jpql="select u from Customer u where u.email =:em and u.password=:pa";
		//String jpqll="select u from Color u ";

		System.out.println("in AuthenticateUse");

		return mgr.createQuery(jpql, Customer.class).setParameter("em", email1).
				setParameter("pa", pwd1).getSingleResult();
		//return null;
	}
	@Override
	public String addCustomerAddress(CustomerAddress transientProduct) {
		String mesg="Product added successfully"; 
		//transientProduct.setCustomer(null);
		mgr.persist(transientProduct);
		return mesg;
	}
	@Override
	public String updateCustomerProfile(Customer transientProduct) {
		String mesg="Product update successfully"; 
		System.out.println("in update Detail -> product dao" +transientProduct.toString());
		//transientProduct.setSeller(null);
		mgr.merge(transientProduct);		
		return mesg;
	}
	@Override
	public List<CustomerAddress> getCustomerAddress(int id)
	{
		String jpql="Select u from CustomerAddress u where u.userId="+id;
		
		return mgr.createQuery(jpql,CustomerAddress.class).getResultList();
	}
	@Override
	public List<Ordertable> getOrderDetails(int customerId) {
			String jpql="Select u from Ordertable u where u.userId="+customerId;
		
			return mgr.createQuery(jpql,Ordertable.class).getResultList();
		
	}
}
