package com.my.questions.groupingandsorting;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
//https://www.javacodegeeks.com/2021/05/java-8-streams-group-by-multiple-fields-with-collectors-groupingby.html
public class MultipleGroupByPairof {

	public static void main(String[] args) {

		getGroupByPairOf();
	}

	public static void getGroupByPairOf() {
		List<Employee> employees = MultipleGrouping.getEmployees();
		
		Map<Object, Long> employee = employees.stream().collect(Collectors.groupingBy(e -> Pair.of(e.getDesignation(), e.getGender()), Collectors.counting()));
		
		System.out.println("employees  ::::::: " + employee.toString());
	}
	
	public static void getGroupByPairOfStudentIds() {
		List<String> students = Arrays.asList("58", "25", "17", "94");
	}
}
