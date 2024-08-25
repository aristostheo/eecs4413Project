package model;

import java.io.Serializable;

public class CartItem  implements Serializable{
	private int cartItemID;
	private int cartID;
	private Product product;
	private int quantity;
	public int getCartItemID() {
		return cartItemID;
	}
	public void setCartItemID(int cartItemID) {
		this.cartItemID = cartItemID;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
