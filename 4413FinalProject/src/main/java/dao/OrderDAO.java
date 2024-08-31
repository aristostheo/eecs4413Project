package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.OrderDetails;

public class OrderDAO extends BaseDAO implements OrderDAOInterface{


	
	
	public ArrayList<OrderDetails> getAllOrderInformation() {
		
		ArrayList<OrderDetails> result = new ArrayList<OrderDetails>();
		String sql = "select purchaseorders.POID, products.BrandName, products.ProductName, "
				+ "categories.CategoryName, customers.FirstName, customers.LastName, "
				+ "customers.Email, addresses.AddressLine1, addresses.AddressLine2, "
				+ "addresses.City, addresses.State, addresses.ZipCode, addresses.Country, "
				+ "purchaseorders.OrderDate, purchaseorders.TotalAmount, "
				+ "purchaseorders.Status, purchaseorders.ExpectedDeliveryDate, "
				+ "purchaseorderdetails.Quantity "
				+ "from purchaseorders, products, categories, customers, addresses, "
				+ "purchaseorderdetails "
				+ "where purchaseorders.POID = purchaseorderdetails.POID AND "
				+ "purchaseorders.CustomerID = customers.CustomerID AND "
				+ "purchaseorders.ShippingAddressID = addresses.AddressID AND "
				+ "purchaseorderdetails.ProductID = products.ProductID AND "
				+ "products.CategoryID = categories.CategoryID "
				+ "order by purchaseorders.POID;";

		Connection con = getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				OrderDetails order = new OrderDetails();
				
				order.setOrderID(resultSet.getInt("POID"));
				order.setBrand(resultSet.getString("BrandName"));
				order.setProductName(resultSet.getString("ProductName"));
				order.setCatName(resultSet.getString("CategoryName"));
				order.setFirstName(resultSet.getString("FirstName"));
				order.setLastName(resultSet.getString("LastName"));
				order.setEmail(resultSet.getString("Email"));
				order.setAddressLine1(resultSet.getString("AddressLine1"));
				order.setAddressLine2(resultSet.getString("AddressLine2"));
				order.setCity(resultSet.getString("City"));
				order.setState(resultSet.getString("State"));
				order.setZipCode(resultSet.getString("ZipCode"));
				order.setCountry(resultSet.getString("Country"));
				order.setOrderDate(resultSet.getDate("OrderDate"));
				order.setTotalAmt(resultSet.getFloat("TotalAmount"));
				order.setStatus(resultSet.getString("Status"));
				order.setDeliveryDate(resultSet.getDate("ExpectedDeliveryDate"));
				order.setQty(resultSet.getInt("Quantity"));

				result.add(order);
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

}
