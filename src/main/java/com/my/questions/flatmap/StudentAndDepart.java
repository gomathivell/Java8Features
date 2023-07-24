package com.my.questions.flatmap;

public class StudentAndDepart {
	private int id;
	private String name;
	private Integer departsId;
	
	
	public StudentAndDepart(int id, String name, Integer departsId) {
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
	public Integer getDepartsId() {
		return departsId;
	}
	public void setDepartsId(Integer departsId) {
		this.departsId = departsId;
	}
	
}
