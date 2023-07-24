package com.my.questions.groupingandsorting;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultipleGroupByNAggregation {
	
	public static void main(String[] args) {
		
		//Groupby Destination
		getGroupByDestination();
		System.out.println("===============================================================");
		getGroupByDestinationAndGender();
	}

	
	public static void getGroupByDestination() {
		List<Employee> employees = MultipleGrouping.getEmployees();
		
		Map<String, List<Employee>> employee = employees.stream().collect(Collectors.groupingBy(Employee::getDesignation));
		
		System.out.println("employees  ::::::: " + employee.toString());
	}
	
	public static void getGroupByDestinationAndGender() {
		List<Employee> employees = MultipleGrouping.getEmployees();
		
		Map<String, Map<String, List<Employee>>> employeeGroups = employees.stream().collect(Collectors.groupingBy(Employee::getDesignation, Collectors.groupingBy(Employee::getGender)));
		
		System.out.println("employees  ::::::: " + employeeGroups.toString());
	}
	
}
