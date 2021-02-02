package com.app.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer billID;
	@Column(length = 20)
	private Integer cardNumber;
	private String cardHolderName;
	private Integer cvv;
	private String validThrough;
	private int userId;
	public Payment(Integer cardNumber, String cardHolderName, Integer cvv, String validThrough,
			int userId) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.validThrough = validThrough;
		this.userId = userId;
	}
	public Integer getBillID() {
		return billID;
	}
	public void setBillID(Integer billID) {
		this.billID = billID;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	public String getValidThrough() {
		return validThrough;
	}
	public void setValidThrough(String validThrough) {
		this.validThrough = validThrough;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Payment [billID=" + billID + ", cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName
				+ ", cvv=" + cvv + ", validThrough=" + validThrough + ", userId=" + userId + "]";
	}
	
		
}
