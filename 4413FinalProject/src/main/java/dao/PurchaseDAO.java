package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;
import model.PurchaseOrder;

public class PurchaseDAO implements PurchaseDAOInterface{
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}


	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/eStore", "root", "EECS4413");
			System.out.println("Worked!");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<PurchaseOrder> getPurchaseOrderbyCustID(int id) {
		ArrayList<PurchaseOrder> result = new ArrayList<PurchaseOrder>();
		
		String sql = "select * from purchaseorders where CustomerID = '" + id + "';";
		Connection con = null;
		try {
			con = connection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				PurchaseOrder purchase = new PurchaseOrder();
			
				purchase.setPurchaseID(rs.getInt("POID"));
				purchase.setCustID(rs.getInt("CustomerID"));
				purchase.setStatus(rs.getString("Status"));
				purchase.setOrderDate(rs.getDate("OrderDate"));
				purchase.setDeliveryDate(rs.getDate("ExpectedDeliveryDate"));
				purchase.setPrice(rs.getFloat("TotalAmount"));

				result.add(purchase);
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
	
	public PurchaseOrder getPurchaseOrderByPOID(int id, PurchaseOrder pur){
		
		
		String sql = "select * from purchaseorderdetails where POID ='" + id + "';";
		Connection con = null;
		try {
			con = connection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			
				pur.setProductID(rs.getInt("ProductID"));
				pur.setQuantity(rs.getInt("Quantity"));

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
		return pur;
		
		
		
		
	}
	

}
