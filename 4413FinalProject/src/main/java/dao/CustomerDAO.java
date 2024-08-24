package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDAO implements CustomerDAOInterface {
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}


	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/4413project", "root", "xi3yyqokgCiPn_e");
			System.out.println("Worked!");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<Customer> findAllCustomers() {
		List<Customer> result = new ArrayList<Customer>();
		String sql = "select * from Customers";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();
				
				
	            customer.setCustomerId(resultSet.getInt("CustomerID"));
	            customer.setFirstName(resultSet.getString("FirstName"));
	            customer.setLastName(resultSet.getString("LastName"));
	            customer.setPhoneNumber(resultSet.getInt("Phone"));
	            customer.setEmail(resultSet.getString("Email"));
	            customer.setAddress(resultSet.getString("AddressID"));
	            customer.setPassword(resultSet.getString("Password"));
            

				result.add(customer);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		return result;
	}
	
	public Customer findCustomerByEmailPassword(String email, String password) {
		Customer cust = new Customer();
		
		String sql = "select * from customers where email='" + email + "' and password='" + password + "';";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
	            cust.setCustomerId(resultSet.getInt("CustomerID"));
	            cust.setFirstName(resultSet.getString("FirstName"));
	            cust.setLastName(resultSet.getString("LastName"));
	            cust.setPhoneNumber(resultSet.getInt("Phone"));
	            cust.setEmail(resultSet.getString("Email"));
	            cust.setAddress(resultSet.getString("AddressID"));
	            cust.setPassword(resultSet.getString("Password"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		return cust;
	}

}
