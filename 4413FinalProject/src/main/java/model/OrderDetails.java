package model;

import java.io.Serializable;
import java.sql.Date;

public class OrderDetails implements Serializable{

	private int orderID; 
	private String brand;
	private String productName;
	private String catName;
	private String fname;
	private String lname;
	private String email;
	private String add1;
	private String add2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private Date orderDate;
	private float totalAmt;
	private String status;
	private Date deliveryDate;
	private int qty;
	
	public int getOrderID() {
		return this.orderID;
	}
	
	public void setOrderID(int id) {
		this.orderID = id;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String name) {
		this.productName = name;
	}
	
	public String getCatName() {
		return this.catName;
	}
	
	public void setCatName(String cat) {
		this.catName = cat;
	}
	
	public String getFirstName() {
		return this.fname;
	}
	
	public void setFirstName(String name) {
		this.fname = name;
	}
	
	public String getLastName() {
		return this.lname;
	}
	
	public void setLastName(String name) {
		this.lname = name;
	}
	
	public String getFullName() {
		return this.fname + " " + this.lname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddressLine1() {
		return this.add1;
	}
	
	public void setAddressLine1(String add) {
		this.add1 = add;
	}
	
	public String getAddressLine2() {
		return this.add2;
	}
	
	public void setAddressLine2(String add) {
		this.add2 = add;
	}
	
	public String getAddress() {
		if (this.add2 != null) {
			return this.add1 + " " + this.add2 + ", " + this.city + ", " + this.state + ", " + this.zipCode + ", " + this.country;
		} else {
			return this.add1 + ", " + this.city + ", " + this.state + ", " + this.zipCode + ", " + this.country;
		}
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(String zip) {
		this.zipCode = zip;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Date getOrderDate() {
		return this.orderDate;
	}
	
	public void setOrderDate(Date date) {
		this.orderDate = date;
	}
	
	public float getTotalAmt() {
		return this.totalAmt;
	}
	
	public void setTotalAmt(float amt) {
		this.totalAmt = amt;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}
	
	public void setDeliveryDate(Date date) {
		this.deliveryDate = date;
	}
	
	public int getQty() {
		return this.qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
