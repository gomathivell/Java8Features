package com.java.core;

import java.util.HashSet;
import java.util.Set;

public class JavaCoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getSetEmpolyeeUniqueByEqualHashCodeOverride();
	}
	
	//equals/hash code override
	
	static void getSetEmpolyeeUniqueByEqualHashCodeOverride() {
		Employee employee = new Employee(1, "Gomathi", 0, null);
		Employee employee1 = new Employee(1, "Gomathi", 0, null);

		Set<Employee> emp = new HashSet<>();
		emp.add(employee1);
		emp.add(employee);
		
		System.out.println("Output ::" + emp.toString());
	}
	

}
