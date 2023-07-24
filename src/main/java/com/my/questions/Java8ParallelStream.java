package com.my.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.java.core.Employee;


public class Java8ParallelStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getParallelStream();
		
		testParallelStream();
	}
	
	
	//
	static void getParallelStream() {
		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		
		end = System.currentTimeMillis();
		
		long timeTaken = end - start;
		
		System.out.println("TimeTaken :: " +  timeTaken);
		
		start = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("TimeTaken in parallel :: " +  (end - start));
	}
	
	static List<Employee> createEmployee1000() {
		List<Employee> empList = new ArrayList<>();
		
		for (int i = 0; i < 1000; i++) {
			empList.add(new Employee(1, "employee"+i, Long.valueOf(new Random().nextInt(100*100)), "A"));
		}
		return empList;
	}
	
	static void testParallelStream() {
		List<Employee> empList = createEmployee1000();
		
		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		double	salaryWithStream =	empList.stream().map(emp -> emp.getSalary()).mapToDouble(i -> i).average().getAsDouble();
		end = System.currentTimeMillis();
		
		System.out.println("TimeTaken in normal Stream :: " +  (end - start) + "Avg Sal :: " + salaryWithStream);
		start = System.currentTimeMillis();
		double	salaryWithParallelStream = empList.parallelStream().map(emp -> emp.getSalary()).mapToDouble(i -> i).average().getAsDouble();
		end = System.currentTimeMillis();
		
		System.out.println("TimeTaken in Parallel Stream :: " +  (end - start) + "Avg Sal :: " + salaryWithParallelStream);
	}
	
	

}
