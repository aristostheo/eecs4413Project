package model;

import java.io.Serializable;

public class Addresses implements Serializable {
	
	private int custId; 
	private int addID;
	private String addLine1;
	private String addLine2; 
	private String city; 
	private String state;
	private String zipCode;
	private String country;
	
	public int getCustId() {
		return this.custId;
	}
	
	public void setCustId(int id) {
		this.custId = id;
	}
	
	public int getAddId() {
		return this.addID;
	}
	
	public void setAddId(int id) {
		this.addID = id;
	}
	
	public String getAddLine1() {
		return this.addLine1;
	}
	
	public void setAddLine1(String add) {
		this.addLine1 = add;
	}
	
	public String getAddLine2() {
		return this.addLine2;
	}
	
	public void setAddLine2(String add) {
		this.addLine2 = add;
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
	
	public String getFullAddress() {
		if (this.addLine2 != null) {
			return this.addLine1 + " " + this.addLine2 + ", " + this.city + ", " + this.state + ", " + this.zipCode + ", " + this.country;
		} else {
			return this.addLine1 + ", " + this.city + ", " + this.state + ", " + this.zipCode + ", " + this.country;
		}
	}
}
