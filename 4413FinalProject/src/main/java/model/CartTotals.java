package model;

public class CartTotals {
	private double subtotal;
	private double tax;
	private double shipping;
	private double grandtotal;
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getShipping() {
		return shipping;
	}
	public void setShipping(double shipping) {
		this.shipping = shipping;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
}
