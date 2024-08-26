package model;

import java.io.Serializable;

public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	private int adminID;
	private String fname;
	private String lname;
	private String email;
	private String password;
	
	public int getAdminID() {
		return this.adminID;
	}
	
	public void setAdminID(int aid) {
		this.adminID = aid;
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
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
}
