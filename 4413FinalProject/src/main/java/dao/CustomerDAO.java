package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Addresses;
import model.Cart;
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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore", "root", "EECS4413");
			System.out.println("Worked!");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Customer createAnonCustomer() {
		String sql = "INSERT INTO customers (firstname, lastname, email, password, phone, addressID) VALUES (null, null, null, null, null, null)";

		Customer c = new Customer();
		Connection con = null;
		try {
			con = connection();
			PreparedStatement stmt = con.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				c.setCustomerId(generatedKeys.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	
	public void createCustomer(Customer c) {
		String sql = "INSERT INTO customers (firstname, lastname, email, password, phone, addressID) VALUES (?, ?, ?, ?, ?, null)";
		String setAddress = "UPDATE Customers addressID = ? WHERE CustomerID = ?";
		Connection con = null;
		try {
			con = connection();
			PreparedStatement stmt = con.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getFirstName());
			stmt.setString(2, c.getLastName());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getPassword());
			stmt.setLong(5, c.getPhoneNumber());
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				c.setCustomerId(generatedKeys.getInt(1));
				c.getAddress().setCustId(generatedKeys.getInt(1));
			}
			createAddress(c.getAddress());
			
			PreparedStatement s = con.prepareStatement(setAddress);
			s.setInt(1, c.getAddress().getAddId());
			s.setInt(2, c.getCustomerId());
			s.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createAddress(Addresses a) {
		String sql = "INSERT INTO addresses (customerID, addressline1, addressline2, city, state, zipcode, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Integer addID = null;
		Connection con = null;
		try {
			con = connection();
			PreparedStatement stmt = con.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, a.getCustId());
			stmt.setString(2, a.getAddLine1());
			stmt.setString(3, a.getAddLine2());
			stmt.setString(4, a.getCity());
			stmt.setString(5, a.getState());
			stmt.setString(6, a.getZipCode());
			stmt.setString(7, a.getCountry());
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				a.setAddId(generatedKeys.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public Addresses getAddress(int addressID) {
		Addresses a = new Addresses();
		
		String sql = "select * from addresses where addressid= ?";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, addressID);
			ResultSet r =  statement.executeQuery();
			while (r.next()) {
				
				a.setAddId(r.getInt(1));
				a.setCustId(r.getInt(2));
				a.setAddLine1(r.getString(3));
				a.setAddLine2(r.getString(4));
				a.setCity(r.getString(5));
				a.setState(r.getString(6));
				a.setZipCode(r.getString(7));
				a.setCountry(r.getString(8));
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
		return a;
		
	}
	
	public void getCustAddresses(Customer c) {
		Addresses a = new Addresses();
		
		String sql = "select * from addresses where customerID= ?";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, c.getCustomerId());
			ResultSet r =  statement.executeQuery();
			while (r.next()) {
				a.setAddId(r.getInt(1));
				a.setCustId(r.getInt(2));
				a.setAddLine1(r.getString(3));
				a.setAddLine2(r.getString(4));
				a.setCity(r.getString(5));
				a.setState(r.getString(6));
				a.setZipCode(r.getString(7));
				a.setCountry(r.getString(8));
				c.setAddress(a);
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
	            
	            int addID = resultSet.getInt("AddressID");
	            
	            customer.setAddress(getAddress(addID));
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
		
		String sql = "select * from customers where email= ? and password= ?";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email.trim());
			statement.setString(2, password.trim());
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				
	            cust.setCustomerId(resultSet.getInt("CustomerID"));
	            System.out.println(resultSet.getString("FirstName"));
	            cust.setFirstName(resultSet.getString("FirstName"));
	            cust.setLastName(resultSet.getString("LastName"));
	            cust.setPhoneNumber(resultSet.getInt("Phone"));
	            cust.setEmail(resultSet.getString("Email"));
	            
	            int addID = resultSet.getInt("AddressID");
	            
	            cust.setAddress(getAddress(addID));
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
		
		System.out.println("First Name: " + cust.getFirstName());
		return cust;
	}
	
	public int changeCustEmail(String ogEmail, String newEmail) {
		
		String sql = "update customers set customers.Email = '" + newEmail + "' where customers.Email='" + ogEmail + "';";
		Connection con = connection();
		int resultSet = 0;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			resultSet =  statement.executeUpdate();
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
		
		return resultSet;
	}
	
	public int changeCustPassword(String ogPassword, String newPassword) {
		
		String sql = "update customers set customers.Password = '" + newPassword + "' where customers.Password='" + ogPassword + "';";
		Connection con = connection();
		int resultSet = 0;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			resultSet =  statement.executeUpdate();
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
		
		return resultSet;
		
	}

	
	public ArrayList<Customer> getAllCustAndAddress() {
		ArrayList<Customer> results = new ArrayList<>();
		
		String sql = "select customers.CustomerID, customers.FirstName, customers.LastName, "
				+ "customers.Email, customers.Password, customers.phone, "
				+ "addresses.AddressLine1, addresses.AddressLine2, addresses.City, "
				+ "addresses.State, addresses.ZipCode, addresses.Country "
				+ "from customers, addresses "
				+ "where customers.AddressID = addresses.AddressID "
				+ "order by customers.CustomerID;";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				Customer cust = new Customer();
				Addresses a = new Addresses();
	            cust.setCustomerId(resultSet.getInt("CustomerID"));
	            cust.setFirstName(resultSet.getString("FirstName"));
	            cust.setLastName(resultSet.getString("LastName"));
	            cust.setPhoneNumber(resultSet.getLong("phone"));
	            cust.setEmail(resultSet.getString("Email"));
	            cust.setPassword(resultSet.getString("Password"));
	            a.setAddLine1(resultSet.getString("AddressLine1"));
	            a.setAddLine2(resultSet.getString("AddressLine2"));
	            a.setCity(resultSet.getString("City"));
	            a.setState(resultSet.getString("State"));
	            a.setZipCode(resultSet.getString("ZipCode"));
	            a.setCountry(resultSet.getString("Country"));
	            cust.setAddress(a);
	            results.add(cust);
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
		return results;
		
	}

	@Override
	public int changeCustomerFirstName(int id, String name) {

		String sql = "update customers set customers.FirstName = '" + name + "' where customers.CustomerID='" + id + "';";
		Connection con = connection();
		int resultSet = 0;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			resultSet =  statement.executeUpdate();
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
		
		return resultSet;
	}

	@Override
	public int changeCustomerLastName(int id, String name) {
		String sql = "update customers set customers.LastName = '" + name + "' where customers.CustomerID='" + id + "';";
		Connection con = connection();
		int resultSet = 0;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			resultSet =  statement.executeUpdate();
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
		
		return resultSet;
	}

	@Override
	public int changeCustEmailWithID(int id, String email) {
		String sql = "update customers set customers.Email = '" + email + "' where customers.CustomerID='" + id + "';";
		Connection con = connection();
		int resultSet = 0;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			resultSet =  statement.executeUpdate();
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
		
		return resultSet;
	}

	@Override
	public int changeCustPasswordWIthID(int id, String password) {
		String sql = "update customers set customers.Password = '" + password + "' where customers.CustomerID='" + id + "';";
		Connection con = connection();
		int resultSet = 0;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			resultSet =  statement.executeUpdate();
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
		
		return resultSet;
	}

	@Override
	public int changeCustPhoneNumWithID(int id, long number) {
		String sql = "update customers set customers.Phone = '" + number + "' where customers.CustomerID='" + id + "';";
		Connection con = connection();
		int resultSet = 0;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			resultSet =  statement.executeUpdate();
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
		
		return resultSet;
	}

	
}
