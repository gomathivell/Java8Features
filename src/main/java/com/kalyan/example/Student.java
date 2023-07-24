package com.kalyan.example;

import java.util.List;

public class Student {
	
	private int id;
	private String name;
	private List<Department> departsId;
	
	
	
	public Student(int id, String name, List<Department> departsId) {
		super();
		this.id = id;
		this.name = name;
		this.departsId = departsId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Department> getDepartsId() {
		return departsId;
	}
	public void setDepartsId(List<Department> departsId) {
		this.departsId = departsId;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", departsId=" + departsId + "]";
	}

	
}
