package com.my.questions.flatmap;

import java.util.List;

public class Departs {
	
	private String deptId;
	private String depatName;
	private List<Employee> employees;
	
	public Departs(String deptId, String depatName, List<Employee> employees) {
		super();
		this.deptId = deptId;
		this.depatName = depatName;
		this.employees = employees;
	}
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDepatName() {
		return depatName;
	}
	public void setDepatName(String depatName) {
		this.depatName = depatName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
