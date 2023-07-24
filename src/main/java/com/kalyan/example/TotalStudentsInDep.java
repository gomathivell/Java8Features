package com.kalyan.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalStudentsInDep {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		List<Department> departments = new ArrayList<>();
		
	
		List<Department> depStud1 = new ArrayList<>();
		
		depStud1.add(new Department(1,"IT"));
		depStud1.add(new Department(4,"MATHS"));
		
		List<Department> depStud2 = new ArrayList<>();
		depStud2.add(new Department(2,"ECE"));
		depStud2.add(new Department(4,"MATHS"));
		
		List<Department> depStud3 = new ArrayList<>();
		depStud3.add(new Department(1,"ECE"));
		depStud3.add(new Department(3,"DRAWING"));
		depStud3.add(new Department(4,"MATHS"));
		
		List<Department> depStud4 = new ArrayList<>();
		depStud4.add(new Department(1,"IT"));
		depStud4.add(new Department(3,"DRAWING"));
		depStud4.add(new Department(4,"MATHS"));
				
		students.add(new Student(111,"Kalyan",depStud1));
		students.add(new Student(222,"Goms",depStud2));
		students.add(new Student(333,"Reyansh",depStud3));
		students.add(new Student(333,"Reyansh",depStud4));
		
		List<Department> depatmentCount = students.stream().flatMap(dep -> dep.getDepartsId().stream()).collect(Collectors.toList());
		
		System.out.println(" depatmentCount :::::::: " + depatmentCount.toString());
		
		depatmentCount.stream().collect(Collectors.groupingBy(Department::getDepartmentId,Collectors.counting()));
		
		System.out.println(depatmentCount.stream().collect(Collectors.groupingBy(Department::getDepartmentId,Collectors.counting())));
		
	}

}
