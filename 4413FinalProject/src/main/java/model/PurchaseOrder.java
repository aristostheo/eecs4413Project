package model;

import java.io.Serializable;
import java.sql.Date;

public class PurchaseOrder implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int purchaseID;
	private int productID;
	private String productName;
	private String productDesc;
	private int quantity;
	private float price;
	private int custID;
	private String status;
	private Date orderDate;
	private Date deliveryDate;
	
	public int getPurchaseID() {
		return this.purchaseID;
	}
	
	public void setPurchaseID(int pid) {
		this.purchaseID = pid;
	}
	
	public int getProductID() {
		return this.productID;
	}
	
	public void setProductID(int pid) {
		this.productID = pid;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int qty) {
		this.quantity = qty;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getCustID() {
		return this.custID;
	}
	
	public void setCustID(int cid) {
		this.custID = cid;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getOrderDate() {
		return this.orderDate;
	}
	
	public void setOrderDate(Date order) {
		this.orderDate = order;
	}
	
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}
	
	public void setDeliveryDate(Date delivery) {
		this.deliveryDate = delivery;
	}
	
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String name) {
		this.productName = name;
	}
	
	public String getProductDesc() {
		return this.productDesc;
	}
	
	public void setProductDesc(String desc) {
		this.productDesc = desc;
	}

}
