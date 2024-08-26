package model;

import java.io.Serializable;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	String name;
	private String categoryDescription;


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return this.categoryDescription;
	}

	public void setDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String toString() {
		return "Category - Id: " + id + ", Category Name: " + this.name + ", Category Description: " + this.categoryDescription;
	}

}
