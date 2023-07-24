package com.my.questions.flatmap;

import java.util.List;

public class Student {
	private int id;
	private String name;
	private List<Department> departs;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(int id, String name, List<Department> departs) {
		super();
		this.id = id;
		this.name = name;
		this.departs = departs;
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

	public List<Department> getDeparts() {
		return departs;
	}

	public void setDeparts(List<Department> departs) {
		this.departs = departs;
	}

}
