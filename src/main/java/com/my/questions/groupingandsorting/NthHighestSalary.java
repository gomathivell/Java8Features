package com.my.questions.groupingandsorting;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class NthHighestSalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> emp = new HashMap<String, Integer>();
		emp.put("Anil", 1000);
		emp.put("Ram", 1300);
		emp.put("Kalyan", 1500);
		emp.put("Kalpa", 1600);
		emp.put("Sar", 1000);
		emp.put("Latheesh", 1700);
		emp.put("Re", 1400);
		emp.put("Reyansh", 1400);
		emp.put("Raj", 1200);
		emp.put("Rajen", 1200);
		
		emp = getNthHighestSalary(emp, 1);
		
		//System.out.println(emp);
	}
	
	// 1) Grouping and
	// 2) Sorting 
	public static Map<String, Integer> getNthHighestSalary(Map<String, Integer> emp, int n) {
		
		Map.Entry<Integer, List<String>> lss = 	emp.entrySet()
		.stream()
		.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
		.entrySet()
		.stream()
		.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))  // got previous collect() method Map.key
		.collect(Collectors.toList())
		.get(n-1);
		
		
	/*	List<Entry<Integer, List<String>>> lss = 	emp.entrySet()
				.stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))  // got previous collect() method Map.key
				.collect(Collectors.toList());
			//	.get(n-1);
*/		
		
/*		List<Map.Entry<Integer, List<Map.Entry<String, Integer>>>> lss = 	emp.entrySet()
				.stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.toList()))
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toList());
			//	.get(n-1);
*/		
		
		System.out.println(lss);
		return emp;
		
	}

}
