package com.my.questions.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors_mapping {
	
	static List<Employee> employeeList
    = Arrays.asList(new Employee("Tom Jones", 45, 15000.00),
    new Employee("Harry Andrews", 45, 7000.00),
    new Employee("Ethan Hardy", 65, 8000.00),
    new Employee("Nancy Smith", 22, 10000.00),
    new Employee("Deborah Sprightly", 29, 9000.00));


	public static void main(String[] args) {

		List<String> ls = employeeList.stream().collect(Collectors.mapping(Employee::getName, Collectors.toList()));
		
		System.out.println(ls.toString());
		
		
		Optional<Integer> out = employeeList.stream().collect(Collectors.mapping((Employee emp) -> emp.getAge(), Collectors.maxBy(Integer::compareTo)));
		
		System.out.println(out.get());
		
		
		
		Stream<String> s = Stream.of("apple", "banana", "orange");
		
		s.collect(Collectors.mapping(s1 -> s1, downstream))
	}

}
