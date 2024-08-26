package model;

import java.io.Serializable;
import java.util.List;

public class Cart  implements Serializable{
	private int cartID;
	private int custID;
	private List<CartItem> items;
	private double total;
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	public CartItem getCartItem(int cartItemID) {
		for(CartItem ci : items) {
			if (ci.getCartItemID() == cartItemID) {
				return ci;
			}
		}
		return null;
	}
	public Integer getCartItemID(int productID) {
		for(CartItem ci : items) {
			if (ci.getProduct().getId() == productID) {
				return ci.getCartItemID();
			}
		}
		return null;
	}
	public void calculateTotal() {
		double total = 0;
		for(CartItem i : items) {
			total += i.getTotal();
		}
		this.total = total;
	}
	public double getTotal() {
		this.calculateTotal();
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
