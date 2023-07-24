package com.java.core;

public class Product {
	
	private String name;
	private int price;
	private String department;
	
	
	public Product() {
	}

	public Product(String name, int price, String department) {
		super();
		this.name = name;
		this.price = price;
		this.department = department;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	

}
