package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Ordertable {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "Order_id" )
	private int orderId;
	@Column( name = "Ship_ADDRESS",length=1000)
	private String shipAddress;
	private String payment;
	private int userId;
	private int sellerId;
	private int productId;
	private double price;
	private int quantity;
	@Column(columnDefinition="DATETIME")
	private Date date;
	/*@ManyToOne
	private Shipper shipper;*/
	
	//default constructor
	public Ordertable() {
		super();
	}



	



	public Ordertable(String shipAddress, String payment, int userId, int sellerId, int productId,
			double price, int quantity, Date date) {
		super();
		
		this.shipAddress = shipAddress;
		this.payment = payment;
		this.userId = userId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
	}







	public int getQuantity() {
		return quantity;
	}







	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}







	public Date getDate() {
		return date;
	}







	public void setDate(Date date) {
		this.date = date;
	}







	public String getPayment() {
		return payment;
	}



	public void setPayment(String payment) {
		this.payment = payment;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getSellerId() {
		return sellerId;
	}



	public void setSellerId(int sellerId) {
		sellerId = sellerId;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}



	@Override
	public String toString() {
		return "Ordertable [orderId=" + orderId + ", shipAddress=" + shipAddress + ", payment=" + payment + ", userId="
				+ userId + ", sellerId=" + sellerId + ", productId=" + productId + ", price=" + price + ", date=" + date
				+ "]";
	}



	

	
	
	

}
