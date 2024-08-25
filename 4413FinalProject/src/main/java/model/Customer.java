package model;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private int CustomerID;
	private String firstName; 
	private String lastName;
	private String email; 
	private long phoneNumber;
	private String addLine1;
	private String addLine2;
	private String addressID;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String password;
	
	public int getCustomerId() {
		return this.CustomerID;
	}
	
	public void setCustomerId(int id) {
		this.CustomerID = id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPhoneNumber() {
		return this.phoneNumber; 
	}
	
	public void setPhoneNumber(long number) {
		this.phoneNumber = number;
	}
	
	public String getAddressLine1() {
		return this.addLine1;
	}
	
	public void setAddressLine1(String add) {
		this.addLine1 = add;
	}
	
	public String getAddressLine2() {
		return this.addLine2;
	}
	
	public void setAddressLine2(String add) {
		this.addLine2 = add;
	}
	
	public String getAddress() {
		return this.addressID;
	}
	
	public void setAddress(String address) {
		this.addressID = address;
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
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// puts all the address info together in order, separated by commas
	public String getFullAddress() {
		String address = "";
		if (this.addLine2 != null) {
			address = this.addLine1 + " " + this.addLine2 + ", " + this.city + ", " + this.state + ", " + this.zipCode + ", " + this.country;
		} else {
			address = this.addLine1 + ", " + this.city + ", " + this.state + ", " + this.zipCode + ", " + this.country;
		}
		return address;
	}
	
	// returns fname + lname
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

}
