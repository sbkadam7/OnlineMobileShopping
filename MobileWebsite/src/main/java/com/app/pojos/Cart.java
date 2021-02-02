package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer cartID;
	private Integer quantity;
	private double price;
	private int user_id;
	private int product_id;
	private String color;
	private String ram;
	private String rom;
	private String productName;
	
	
	public Cart() {
		super();
	}



	public Cart( String productName, Integer quantity, double price, int user_id, int product_id,
			String color, String ram, String rom) {
		super();
		
		this.quantity = quantity;
		this.price = price;
		this.user_id = user_id;
		this.product_id = product_id;
		this.color = color;
		this.ram = ram;
		this.rom = rom;
		this.productName=productName;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public Integer getCartID() {
		return cartID;
	}



	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}



	



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public int getProduct_id() {
		return product_id;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getRam() {
		return ram;
	}



	public void setRam(String ram) {
		this.ram = ram;
	}



	public String getRom() {
		return rom;
	}



	public void setRom(String rom) {
		this.rom = rom;
	}



	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", quantity=" + quantity + ", price=" + price
				+ ", user_id=" + user_id + ", product_id=" + product_id + ", color=" + color + ", ram=" + ram + ", rom="
				+ rom + "]";
	}
	


}
