package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SellerAddress {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer AddressId;
	private String fullName;
	private String mobile;
	private String country;
	private String pinCode;
	private String flat;
	private String area;
	private String landmark;
	private String city;
	private String state;
	private int sellerId;

	public SellerAddress()
	{
		super();
	}

	public SellerAddress(Integer addressId, String fullName, String mobile, String country, String pinCode,
			String flat, String area, String landmark, String city, String state, Integer sellerId) {
		super();
		AddressId = addressId;
		this.fullName = fullName;
		this.mobile = mobile;
		this.country = country;
		this.pinCode = pinCode;
		this.flat = flat;
		this.area = area;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.sellerId = sellerId;
	}

	public SellerAddress(Integer addressId, String fullName, String mobile, String country, String pinCode,
			String flat, String area, String landmark, String city, String state) {
		super();
		AddressId = addressId;
		this.fullName = fullName;
		this.mobile = mobile;
		this.country = country;
		this.pinCode = pinCode;
		this.flat = flat;
		this.area = area;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
	}

	public Integer getAddressId() {
		return AddressId;
	}

	public void setAddressId(Integer addressId) {
		AddressId = addressId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "CustomerAddress [AddressId=" + AddressId + ", fullName=" + fullName + ", mobile=" + mobile
				+ ", country=" + country + ", pinCode=" + pinCode + ", flat=" + flat + ", area=" + area + ", landmark="
				+ landmark + ", city=" + city + ", state=" + state + ", sellerId=" + sellerId + "]";
	}
	
	
}
