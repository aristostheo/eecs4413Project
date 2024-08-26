package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Addresses;
import model.Customer;

public interface CustomerDAOInterface {
	
	
	public List<Customer> findAllCustomers();
	public Customer findCustomerByEmailPassword(String email, String password);
	
	public int changeCustEmail(String ogEmail, String newEmail);
	public int changeCustPassword(String ogPassword, String newPassword);
	
	public ArrayList<Customer> getAllCustAndAddress();
	
	public int changeCustomerFirstName(int id, String name);
	public int changeCustomerLastName(int id, String name);
	public int changeCustEmailWithID(int id, String email);
	public int changeCustPasswordWIthID(int id, String password);
	public int changeCustPhoneNumWithID(int id, long number);
	public Customer createAnonCustomer();
	public void createCustomer(Customer c);
	public void createAddress(Addresses a);
	public Addresses getAddress(int addressID);
	

}
