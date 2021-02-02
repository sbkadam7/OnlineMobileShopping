package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*
//@Entity
public class Shipper {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "Shipper_id" )
	private int shipperId;
	@Column( name = "Comp_Name")
	private String companyName;
	@Column( name = "Phone")
	private int phoneNo;
	
	//@OneToMany (mappedBy = "shipper")
	//private List<Order> orders =new ArrayList<>();

	public Shipper() {
		super();
	}
	
	

	public Shipper(String companyName, int phoneNo, List<Order> orders) {
		super();
		this.companyName = companyName;
		this.phoneNo = phoneNo;
		this.orders =  orders;
	}



	public Shipper(int shipperId, String companyName, int phoneNo, List<Order> orders) {
		super();
		this.shipperId = shipperId;
		this.companyName = companyName;
		this.phoneNo = phoneNo;
		this.orders = orders;
	}



	public int getShipperId() {
		return shipperId;
	}



	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public int getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}



	public List<Order> getOrders() {
		return orders;
	}



	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	@Override
	public String toString() {
		return "Shipper [shipperId=" + shipperId + ", companyName=" + companyName + ", phoneNo=" + phoneNo + ", orders="
				+ orders + "]";
	}
	
	
	
	

}*/
