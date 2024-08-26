package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Addresses;

public class AddressesDAO implements AddressesDAOInterface{
	
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

	@Override
	public int changeAddressLine1WithId(int id, String addLine) {
		String sql = "update addresses set addresses.AddressLine1 = '" + addLine + "' where addresses.CustomerID='" + id + "';";
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
	public int changeAddressLine2WithId(int id, String addLine) {
		String sql = "update addresses set addresses.AddressLine2 = '" + addLine + "' where addresses.CustomerID='" + id + "';";
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
	public int changeCityWithId(int id, String city) {
		String sql = "update addresses set addresses.City = '" + city + "' where addresses.CustomerID='" + id + "';";
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
	public int changeStateWithId(int id, String state) {
		String sql = "update addresses set addresses.State = '" + state + "' where addresses.CustomerID='" + id + "';";
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
	public int changeZipcodeWithId(int id, String zip) {
		String sql = "update addresses set addresses.ZipCode = '" + zip + "' where addresses.CustomerID='" + id + "';";
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
	public int changeCountryWithId(int id, String country) {
		String sql = "update addresses set addresses.Country = '" + country + "' where addresses.CustomerID='" + id + "';";
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
