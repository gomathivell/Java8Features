package com.my.questions.flatmap;

import java.util.List;

public class EmployeeCity {
	private String id;
	private String name;	
	private List<String> cities;
	
	public EmployeeCity(String id, String name, List<String> cities) {
		super();
		this.id = id;
		this.name = name;
		this.cities = cities;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

}
