package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import model.Cart;
import model.CartItem;
import model.Product;

public class CartDAO implements CartDAOInterface {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}
	
	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore", "root", "EECS4413");
//			System.out.println("Worked!");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public Cart createCart(int customerID) {
		Cart c = new Cart();
		Connection con = null;
		try {
			con = connection();
			PreparedStatement stmt = con.prepareStatement(
					"insert into Cart(customerID) values (?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, customerID);
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				c.setCartID(generatedKeys.getInt(1));
			}
			c.setCustID(customerID);
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
		return c;
	}
	
	@Override
	public Cart getCart(int customerID) {
		Cart c = null;
		
		String sql = "select * from Cart where customerID = ?";
		
		Connection con = null;
		try {
			con = connection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, customerID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				c = new Cart();
				c.setCartID(rs.getInt(1));
				c.setCustID(rs.getInt(2));
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
		return c;
	}
	
	@Override
	public void populateCartItems(Cart c) {
		List<CartItem> cartItems = new ArrayList<CartItem>();
		
		String sql = "select * from CartItem where cartID = ?";

				
		Connection con = null;
		try {
			con = connection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, c.getCartID());
			ResultSet rs = stmt.executeQuery();
			
			ProductDAOInterface productDAO = new ProductDAO();
			
			while (rs.next()) {
				CartItem item = new CartItem();
				
				item.setCartItemID(rs.getInt(1));
				item.setCartID(rs.getInt(2));
				item.setProduct(productDAO.getProduct(rs.getInt(3)));
				item.setQuantity(rs.getInt(4));
				
				cartItems.add(item);
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
		
		c.setItems(cartItems);
	}
	
	@Override
	public void addCartItem(int cartID, int productID, int quantity) {
		CartItem cartItem = new CartItem();
		Connection con = null;
		try {
			con = connection();
			ProductDAOInterface productDAO = new ProductDAO();
			
			PreparedStatement stmt = con.prepareStatement(
					"insert into CartItem(cartID, productID, quantity) values (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, cartID);
			stmt.setInt(2, productID);
			stmt.setInt(3, quantity);
			
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				cartItem.setCartItemID(generatedKeys.getInt(1));
			}
			cartItem.setCartID(cartID);
			cartItem.setProduct(productDAO.getProduct(productID));
			cartItem.setQuantity(quantity);
			
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

	@Override
	public Integer checkItemInCartAlready(int cartID, int productID) {
		Integer cartItemID = null;
		Connection con = null;
		try {
			con = connection();
			
			PreparedStatement stmt = con.prepareStatement(
					"select * from CartItem where cartID = ? and productID = ?");
			stmt.setInt(1, cartID);
			stmt.setInt(2, productID);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				cartItemID = rs.getInt(1);
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
		return cartItemID;
	}
	
	@Override 
	public void updateCartItem(int cartItemID, int quantity) {
		Connection con = null;
		try {
			con = connection();
			
			PreparedStatement stmt = con.prepareStatement(
					"update CartItem set quantity = ? where cartItemID = ?");
			stmt.setInt(1, quantity);
			stmt.setInt(2, cartItemID);
			
			stmt.executeUpdate();
			
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
	
	@Override
	public void removeCartItem(int cartItemID) {
		Connection con = null;
		try {
			con = connection();
			
			PreparedStatement stmt = con.prepareStatement(
					"delete from CartItem where cartItemID = ?");
			stmt.setInt(1, cartItemID);
			stmt.executeUpdate();
			
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

}
