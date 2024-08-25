package model;

import java.io.Serializable;

public class Product implements Serializable{
	private int id;
	private String brand;
	private String name;
	private int catID;
	private float price;
	private int stockQty;
	private String desc;
	private String img;
	
//	public Product(int id, String brand, String name, int catID, int supplierID, float price, int stockQty, String desc) {
//		super();
//		this.id = id;
//		this.brand = brand;
//		this.name = name;
//		this.catID = catID;
//		this.supplierID = supplierID;
//		this.price = price;
//		this.stockQty = stockQty;
//		this.desc = desc;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return this.brand;
	}	

	public void setBrand(String newBrand) {
		this.brand = newBrand;
	}
	public String getName() {
		return this.name;
	}	
	public void setName(String newName) {
		this.name = newName;
	}	
	public int getStockQty() {
		return this.stockQty;
	}
	public void setStockQty(int newQty) {
		this.stockQty = newQty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCatID() {
		return this.catID;
	}
	public void setCatID(int catid) {
		this.catID = catid;
	}
	public String getDesc() {
		return this.desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImg() {
		System.out.println("img URL: " + img);
		return img;
	}
	public void setImg(String imgURL) {
		this.img = imgURL;
	}
	

	

}
