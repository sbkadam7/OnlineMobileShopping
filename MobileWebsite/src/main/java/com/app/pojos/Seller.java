package com.app.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Seller {

	


	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "Seller_id" ,length = 12)
	private int sellerId;
	@Column(name = "First_name" )
	private String firstName;
	@Column(name = "Last_name" )
	private String lastName;
	@Column(name = "Mobile" ,length = 12)
	private int mobileNo;
	@Column(name = "Email", unique = true )
	private String email;
	@Column(name = "Password" )
	private String password;
	@Column(name = "Shop_name" )
	private String shopName;
	@Column(name = "GST", unique = true )
	private String gst;
	@Column(name = "PanCard", unique = true )
	private String panCard;
	@Column(name = "Approval" )
	private String approval;
	//Signup date is remaining
	
	/*Change at 21-01 20.18
	 * @OneToMany(mappedBy = "seller", cascade=CascadeType.ALL)
	private List<Product> product = new ArrayList<>();*/
	
	
	
	public Seller() {
		super();
	}
	
	
	public Seller(String firstName, String lastName, int mobileNo, String email, String password, String shopName,
			String gst, String panCard, String approval) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.shopName = shopName;
		this.gst = gst;
		this.panCard = panCard;
		this.approval = approval;
	}


	public Seller(int sellerId, String firstName, String lastName, int mobileNo, String email, String password,
			String shopName, String gst, String panCard, String approval) {
		super();
		this.sellerId = sellerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.shopName = shopName;
		this.gst = gst;
		this.panCard = panCard;
		this.approval = approval;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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


	public int getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public String getGst() {
		return gst;
	}


	public void setGst(String gst) {
		this.gst = gst;
	}


	public String getPanCard() {
		return panCard;
	}


	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}


	public String getApproval() {
		return approval;
	}


	public void setApproval(String approval) {
		this.approval = approval;
	}
	/*
	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}
*/

	


	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNo="
				+ mobileNo + ", email=" + email + ", password=" + password + ", shopName=" + shopName + ", gst=" + gst
				+ ", panCard=" + panCard + ", approval=" + approval +  "]";
	}
	
	
	
	
	
}
