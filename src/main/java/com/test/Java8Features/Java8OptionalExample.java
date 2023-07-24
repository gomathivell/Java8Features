package com.test.Java8Features;

import java.util.Optional;

public class Java8OptionalExample {
	
	//single objects means use Optional class to do filter , map and validation

	 public static void main(String[] args) {
		 Optional<Employee> emp = Optional.empty();
		 Employee employee = emp.orElse(new Employee(1, "Goms", 12000)); // Terory operator can be used.
	//	 Employee employe = emp.orElseThrow();
		 
		 
		 emp.filter(empl -> "Goms".equals(empl.getName())).ifPresent((name) -> System.out.println("Testing"));
	 }
}
