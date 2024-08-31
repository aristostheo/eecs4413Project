package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PurchaseOrder;

public class PurchaseDAO extends BaseDAO implements PurchaseDAOInterface{
	


	public ArrayList<PurchaseOrder> getPurchaseOrderbyCustID(int id) {
		ArrayList<PurchaseOrder> result = new ArrayList<PurchaseOrder>();
		
		String sql = "select * from purchaseorders where CustomerID = '" + id + "';";
		Connection con = null;
		try {
			con = getConnection();
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
			con = getConnection();
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
