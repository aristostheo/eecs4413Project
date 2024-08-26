package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Customer;

public class AdminDAO implements AdminDAOInterface{
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}


	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/4413project", "root", "EECS4413");
			System.out.println("Worked!");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	
	public List<Admin> findAllAdmins() {
		List<Admin> result = new ArrayList<Admin>();
		String sql = "select * from Admin;";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				Admin admin = new Admin();
		
				admin.setAdminID(resultSet.getInt("AdminID"));
				admin.setFirstName(resultSet.getString("FirstName"));
				admin.setLastName(resultSet.getString("LastName"));
				admin.setEmail(resultSet.getString("Email"));
				admin.setPassword(resultSet.getString("Password"));
            

				result.add(admin);
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

	
	public Admin findAdminByEmailPassword(String email, String password) {
		Admin admin = new Admin();
		
		String sql = "select * from Admin where email='" + email + "' and password='" + password + "';";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				admin.setAdminID(resultSet.getInt("AdminID"));
				admin.setFirstName(resultSet.getString("FirstName"));
				admin.setLastName(resultSet.getString("LastName"));
				admin.setEmail(resultSet.getString("Email"));
				admin.setPassword(resultSet.getString("Password"));
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
		return admin;
	}

	
	public int changeAdminEmail(String ogEmail, String newEmail) {
		String sql = "update Admin set Admin.Email = '" + newEmail + "' where Admin.Email='" + ogEmail + "';";
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

	
	public int changeAdminPassword(String ogPassword, String newPassword) {
		String sql = "update Admin set Admin.Password = '" + newPassword + "' where Admin.Password='" + ogPassword + "';";
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
