package com.my.questions.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.my.questions.Employee;

public class DepartmentAndStudent {

	
	//minimum 2 students in a department - needs to get that department
	//find count of departs occured in student's list of department and filter >3 
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1, "Gomathi", Arrays.asList(new Department(1, "ECE"), new Department(2, "CSE"))));
		students.add(new Student(2, "Kal", Arrays.asList(new Department(3, "EEE"), new Department(2, "CSE"))));
		students.add(new Student(3, "Reyansh", Arrays.asList(new Department(1, "ECE"), new Department(2, "CSE"))));
		students.add(new Student(4, "Latheesh", Arrays.asList(new Department(1, "ECE"), new Department(4, "IT"))));
		students.add(new Student(5, "Raj", Arrays.asList(new Department(1, "ECE"), new Department(2, "CSE"))));
		
		
		List<Department> departments = new ArrayList<>();
		
		departments.add(new Department(1, "ECE"));
		departments.add(new Department(2, "CSE"));
		departments.add(new Department(3, "EEE"));
		departments.add(new Department(4, "IT"));
		
		List<Department>  studentsList = students.stream().flatMap(student -> student.getDeparts().stream()).collect(Collectors.toList());
		
		List<Integer> output = studentsList.stream().collect(Collectors.groupingBy(Department::getId, Collectors.counting()))
				.entrySet().stream()
				.filter( d -> d.getValue() >3)
				.map( dName -> dName.getKey())
				.collect(Collectors.toList());
		
		
		
		System.out.println("output ::" + output.toString());
		
		
		//filtering from list of ids using objs.contains
		List<Department> results = departments.stream().filter( dep -> output.contains(dep.getId())).collect(Collectors.toList());
//		List<Department> result = departments.stream().filter( dep -> dep.getId() == 1 || dep.getId() ==2).map( de -> de).collect(Collectors.toList());
		
		
		results.stream().forEach(d -> System.out.println(d.getDepartmentName()));

	}
	
	
	public static void getDepartmentFor2Students() {
		
	List<StudentAndDepart> students = new ArrayList<>();
		
		students.add(new StudentAndDepart(1, "Gomathi", 1));
		students.add(new StudentAndDepart(1, "Gomathi", 2));
		
		students.add(new StudentAndDepart(2, "Kal", 2));
		students.add(new StudentAndDepart(2, "Kal", 3));
		students.add(new StudentAndDepart(3, "Reyansh", 1));
		students.add(new StudentAndDepart(3, "Reyansh", 2));
		
		students.add(new StudentAndDepart(4, "Latheesh", 1));
		students.add(new StudentAndDepart(4, "Latheesh", 4));
		students.add(new StudentAndDepart(5, "Raj", 1));
		students.add(new StudentAndDepart(5, "Raj", 2));
		
		
		Map<Integer, List<StudentAndDepart>> studentsOutput = students.stream().collect(Collectors.groupingBy(StudentAndDepart::getDepartsId, Collectors.toList()));
		
		System.out.println("   studentsOutput ::: " + studentsOutput.toString());
		
		Set<Entry<Integer, List<StudentAndDepart>>>  out = studentsOutput.entrySet();
		
		for(Entry<Integer, List<StudentAndDepart>>  entry : out) {
			
			System.out.println("Depart: " + entry.getKey());
			
			System.out.println("-------------------------------");
			
			List<StudentAndDepart> studentLs = entry.getValue();
			
			studentLs.stream().forEach(e -> System.out.println(e.getName()));
			
			System.out.println("=====================================");
		}
		
		
		List<Map.Entry<Integer,List<StudentAndDepart>>>  result = studentsOutput.entrySet().stream().filter( s -> s.getValue().size() >=2 )
		.map(c -> c)
		.collect(Collectors.toList());
		
		System.out.println(result.toString());
		
	}

	
	
}
