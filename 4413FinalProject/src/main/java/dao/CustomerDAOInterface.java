package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public interface CustomerDAOInterface {
	
	
	public List<Customer> findAllCustomers();
	public Customer findCustomerByEmailPassword(String email, String password);
	
	public int changeCustEmail(String ogEmail, String newEmail);
	public int changeCustPassword(String ogPassword, String newPassword);
	
	public ArrayList<Customer> getAllCustAndAddress();
	

}
