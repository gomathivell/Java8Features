package com.my.questions.groupingandsorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://www.javacodegeeks.com/2021/05/java-8-streams-group-by-multiple-fields-with-collectors-groupingby.html?amp=1

public class MultipleGrouping {

	public static void main(String[] args) {

		 List<Employee> employeesList = getEmployees();
		        
	        // group by - multiple fields
	        // Grouping by designation and Gender two properties and need to get the count.
	        
	       Map<String, Map<String, Long>> result =  employeesList.stream().collect(Collectors.groupingBy( Employee::getDesignation ,
	        		Collectors.groupingBy(Employee::getGender,  Collectors.counting())));
	       
	       System.out.println("result :::::::: " + result);
	        
	}
	
	public static List<Employee> getEmployees() {
		 List<Employee> employeesList = new ArrayList<>();
		 
	        employeesList.add(new Employee(101, "Glady", "Manager", "Male", 25_00_000));
	        employeesList.add(new Employee(102, "Vlad", "Software Engineer", "Female", 15_00_000));
	        employeesList.add(new Employee(103, "Shine", "Lead Engineer", "Female", 20_00_000));
	        employeesList.add(new Employee(104, "Nike", "Manager", "Female", 25_00_000));
	        employeesList.add(new Employee(105, "Slagan", "Software Engineer", "Male", 15_00_000));
	        employeesList.add(new Employee(106, "Murekan", "Software Engineer", "Male", 15_00_000));
	        employeesList.add(new Employee(107, "Gagy", "Software Engineer", "Male", 15_00_000));
	        
		return employeesList;
	}

}
