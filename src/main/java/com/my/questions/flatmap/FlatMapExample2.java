package com.my.questions.flatmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

//https://www.youtube.com/watch?v=7WXwxnh855M

public class FlatMapExample2 {

	public static void main(String[] args) {
		
		Employee employee = new Employee("11", "Latheesh", 72000.00);
		Employee employee1 = new Employee("12", "Re", 22000.00);
		Employee employee2 = new Employee("13", "Kal", 32000.00);
		Employee employee3 = new Employee("14", "Praksh", 52000.00);
		Employee employee4 = new Employee("15", "Sarwin", 42000.00);
		Employee employee5 = new Employee("16", "Vell", 32000.00);
		
		List<Employee> emps = new ArrayList<>();
		emps.add(employee);
		emps.add(employee1);
		emps.add(employee2);
		emps.add(employee3);
		emps.add(employee4);
		emps.add(employee5);
		
		List<Employee> emps1 = new ArrayList<>();
		
		Employee employee6 = new Employee("17", "Kal11", 23000.00);
		Employee employee7 = new Employee("18", "Praksh11", 78000.00);
		Employee employee8 = new Employee("19", "Sarwin11", 134000.00);
		Employee employee9 = new Employee("20", "Vell11", 47000.00);
		
		emps1.add(employee6);
		emps1.add(employee7);
		emps1.add(employee8);
		emps1.add(employee9);
		
		List<Employee> emps2 = new ArrayList<>();
		
		
		Employee employee10 = new Employee("21", "Kal22", 3300.00);
		Employee employee11 = new Employee("22", "Praksh22", 92000.00);
		Employee employee12 = new Employee("23", "Sarwin22", 41000.00);
		Employee employee13 = new Employee("24", "Vell22", 31000.00);
		Employee employee14 = new Employee("25", "Tamil", 23000.00);
		
		emps2.add(employee10);
		emps2.add(employee11);
		emps2.add(employee12);
		emps2.add(employee13);
		emps2.add(employee14);
		
		
		Departs departs = new Departs("101", "Dev", emps);
		Departs departs1 = new Departs("102", "Sales", emps1);
		Departs departs2 = new Departs("103", "HR", emps2);
		
		List<Departs> departsList = new ArrayList<>();
		
		departsList.add(departs);
		departsList.add(departs1);
		departsList.add(departs2);
		
		//Get Highest salary in Dept 101
			
		OptionalDouble  output = departsList.stream().filter( dept -> dept.getDeptId().equalsIgnoreCase("101"))
			.flatMap(dept -> dept.getEmployees().stream())
			.mapToDouble(em -> em.getSalary()).max();
		
		System.out.println("output  ::::::: " + output.getAsDouble());
		
		
		
		//Max Salary of all the departments
		
		OptionalDouble  maxSalary = departsList.stream().flatMap(dept -> dept.getEmployees().stream()).mapToDouble(emp -> emp.getSalary()).max();
		
		Employee  maxSalary2 = departsList.stream().flatMap(dept -> dept.getEmployees().stream()).max(Comparator.comparingDouble(Employee::getSalary)).get();
		
		System.out.println("maxSalary  ::::::: " + maxSalary.getAsDouble());
		System.out.println("maxSalary2 :::::::::: " + maxSalary2.getSalary());
	}

}
