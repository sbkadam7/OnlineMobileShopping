package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "Customer_id" ,length = 12)
	private int customerId;
	@Column(name = "First_name")
	private String firstName;
	@Column(name = "Last_name")
	private String lastName;
	
	@Column(name = "Mobile",length = 12)
	private int mobile;
	@Column(name = "Password")
	private String password;
	@Column(name = "Email",unique = true)
	private String email;
	
	

	public Customer() {
		super();
		System.out.println("in customer pojo");
	}

	public Customer(String firstName, String lastName, int mobile, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.password = password;
		this.email = email;
	}
/*
	public Customer(int customerId, String firstName, String lastName, int mobile, String password, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.password = password;
		this.email = email;
		//this.orders = orders;
	}
*/
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	/*
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}*/

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobile=" + mobile + ", password=" + password + ", email=" + email + "]";
	}
	
	
	
	
}
