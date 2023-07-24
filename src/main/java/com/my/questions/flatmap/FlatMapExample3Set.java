package com.my.questions.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample3Set {

	//Unique city list using flatMap
	public static void main(String[] args) {

		List<String> cities = new ArrayList<>();
		
		cities.add("Pune");
		cities.add("Mumbai");
		cities.add("Noida");
		cities.add("Banglore");
		cities.add("Chennai");
		
		
List<String> cities1 = new ArrayList<>();
		
		cities1.add("Coimabtore");
		cities1.add("Mumbai");
		cities1.add("Noida");
		
List<String> cities2 = new ArrayList<>();
		
		cities2.add("Hyd");
		cities2.add("Madhurai");
		cities2.add("Noida");
		
		EmployeeCity employeeCity = new EmployeeCity("12", "Gomathi", cities);
		
		EmployeeCity employeeCity1 = new EmployeeCity("15", "Durga", cities1);
		EmployeeCity employeeCity2 = new EmployeeCity("16", "Prabha", cities2);
		
		List<EmployeeCity> employeeCities = new ArrayList<>();
		
		employeeCities.add(employeeCity);
		employeeCities.add(employeeCity1);
		employeeCities.add(employeeCity2);
		
		Set<String> result = employeeCities.stream().flatMap(emp -> emp.getCities().stream()).collect(Collectors.toSet());
		
		System.out.println("result  ::: " + result.toString());
	}

}
