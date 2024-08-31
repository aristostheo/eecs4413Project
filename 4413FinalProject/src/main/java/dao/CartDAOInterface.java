package dao;



import model.*;


public interface CartDAOInterface {
	public Cart createCart(int customerID);
	public Cart getCart(int customerID);
	public void populateCartItems(Cart c);
	public void addCartItem(int cartID, int productID, int quantity);
	public Integer checkItemInCartAlready(int cartID, int productID);
	public void updateCartItem(int cartItemID, int quantity);
	public void removeCartItem(int cartItemID);

//	public double getShipping();
	
}	

