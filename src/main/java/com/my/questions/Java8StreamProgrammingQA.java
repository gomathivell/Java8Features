package com.my.questions;
//https://www.youtube.com/watch?v=AFmyV43UBgc
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8StreamProgrammingQA {
	
	static List<Employee> employee = new ArrayList<>();

	public static void main(String[] args) {

		employee.add(new Employee(111, "Gomathi", 25, "Female", "Dev", 2016, 250000.0));
		employee.add(new Employee(112, "Lahari", 35, "Female", "Sales", 2014, 250000.0));
		employee.add(new Employee(113, "Ram", 25, "male", "Dev", 2016, 250000.0));
		employee.add(new Employee(114, "Kal", 55, "Female", "Delivery", 2016, 250000.0));
		employee.add(new Employee(115, "Vatchu", 35, "male", "Delivery", 2017, 250000.0));
		employee.add(new Employee(116, "Lath", 25, "male", "Dev", 2018, 250000.0));
		employee.add(new Employee(117, "Sarwin", 25, "male", "Dev", 2016, 25450.0));
		employee.add(new Employee(118, "Raj", 25, "Female", "Sales", 2014, 250450.0));
		employee.add(new Employee(119, "Vaishu", 25, "Female", "Dev", 2017, 250034.0));
		employee.add(new Employee(120, "vell", 25, "male", "Sales", 2014, 250300.0));
		employee.add(new Employee(121, "Amruth", 25, "Female", "Dev", 2011, 250230.0));
		employee.add(new Employee(122, "Surya", 65, "male", "Delivery", 2012, 2545000.0));
		employee.add(new Employee(123, "Sree", 25, "Female", "HR", 2017, 2500450.0));
		employee.add(new Employee(123, "Vam", 25, "male", "Delivery", 2018, 25040.0));
		
		//Q1 How many Female, Male employees are there in Org
		countOfMaleAndFemale();
		
		//Q2 List Department in Org
		displayDepart();
				
		//Q3 Avg of age of Male and Female employee in Org
		avgAgeOfMaleNFemale();
		
		//Q4 Highest paid employee details in Org
		highestPaidEmployee();
		
		//Q5 display employee name details, who joined after 2015 in Org
		displayEmployeeName();
		
		//Q6 Count employee in each department
		countEmployeeIneachDepart();
		
		//Q7 Avg Salary in each department
		avgSalaryIneachDepart();
		
		//Q8 Youngest employee in Sales department
		getYoungestEmpl();
		
		
		//Q9 who is Most experience person in Org 
		getMostExperiencePerson();
		
		//Q10 How many male and female employees in dev and sales depart
		countMaleNFemaleInDevandSalesDepartment();
		
		//Q11 Avg Salary for male and female employees
		avgSalaryMaleNFemale();
		
		//Q12 List down the all employees in each department
		getNameinEachDepart();
		
		//Q13 what is Avg Salary and total salary whole in org.. 
		getAvgSalaryAndTotalSalary();
		
		//Q14 Separate age younger n =25 and greater then 25 older ppl 
		groupBasedAgeMaleNFemale();
		
		//Q15 oldest Person and his department
		oldestPerson();
	}
	
	public static void countOfMaleAndFemale() {
		System.out.println("Q1 ::: How many Female, Male employees are there in Org");
		Map<String, Long> output = employee.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Result ::: " + output);
	}
	
	public static void displayDepart() {
		System.out.println("Q2 List Department in Org");
		employee.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		//System.out.println("Result ::: " + output);
	}

	public static void avgAgeOfMaleNFemale() {
		System.out.println("Q3 Avg of age of Male and Female employee in Org");
		Map<String, Double> output = employee.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("Result ::: " + output);
	}
	
	public static void highestPaidEmployee() {
		System.out.println("Q4 Highest paid employee details in Org");
		Optional<Employee> output = employee.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("Result ::: " + output.get().getName());
	}
	
	
	public static void displayEmployeeName() {
		System.out.println("Q5 List all employee Name , who joined after 2015?");
		employee.stream().filter(e -> e.getYearOfJoining() > 2015).map(emp -> emp.getName()).forEach(System.out::println);
		//System.out.println("Result ::: " + output.get().getName());
	}
	
	
	public static void countEmployeeIneachDepart() {
		System.out.println("Q6 Count employee in each department");
		Map<String, Long> map = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Result ::: " + map.toString());
	}
	
	
	public static void avgSalaryIneachDepart() {
		System.out.println("Q7 Avg Salary in each department");
		Map<String, Double> map = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Result ::: " + map.toString());
	}
	
	public static void getYoungestEmpl() {
		System.out.println("Q8 Youngest male employee in Sales department");
		Optional<Employee>  employeeDetail= employee.stream().filter( emp -> emp.getDepartment().equalsIgnoreCase("Sales") && emp.getGender().equalsIgnoreCase("male"))
				.min(Comparator.comparing(Employee::getAge));
		System.out.println("Result ::: " + employeeDetail.get().getName());
	}
	
	public static void getMostExperiencePerson() {
		System.out.println("Q9 who is Most experience person in Org ");
		Optional<Employee>  employeeDetail= employee.stream().min(Comparator.comparing(Employee::getYearOfJoining));
		System.out.println("Result ::: " + employeeDetail.get().getName());
		
		//second solution
		//order by year of Joining
		Optional<Employee>  employeeDetails = employee.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
	}
	
	
	public static void countMaleNFemaleInDevandSalesDepartment() {
		System.out.println("Q10 How many male and female employees in Sales depart");
		Map<String, Long>  employeeDetail= employee.stream().filter( emp -> emp.getDepartment().equalsIgnoreCase("Sales")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));       
		System.out.println("Result ::: " + employeeDetail.toString());
	}
	
	
	public static void avgSalaryMaleNFemale() {
		System.out.println("Q11 Avg Salary for male and female employees ");
		Map<String, Double>  employeeDetail= employee.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));       
		System.out.println("Result ::: " + employeeDetail.toString());
	}

	
	public static void getNameinEachDepart() {
		System.out.println("Q12 List down the all employees in each department");
		Map<String, List<Employee>>  employeeDetail= employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));       
		System.out.println("Result ::: " + employeeDetail.toString());
		
		Set<Entry<String, List<Employee>>> entrySet = employeeDetail.entrySet();
		
		for(Entry<String, List<Employee>>  entry : entrySet) {
			
			System.out.println("Depart: " + entry.getKey());
			
			System.out.println("-------------------------------");
			
			List<Employee> empls = entry.getValue();
			
			empls.stream().forEach(e -> System.out.println(e.getName()));
			
			System.out.println("=====================================");
		}
	}
	
	public static void getAvgSalaryAndTotalSalary() {
		System.out.println("Q13 what is Avg Salary and total salary whole in org..  ");
		Double  employeeDetail= employee.stream().collect(Collectors.averagingDouble(Employee::getSalary));       
		
		
		System.out.println("Avg ::: " + employeeDetail.toString());
		
		Double  employeeDetails = employee.stream().collect(Collectors.summingDouble(Employee::getSalary));
		
		System.out.println("Summing ::: " + employeeDetails.toString());
		
		
		//second solution
		
		DoubleSummaryStatistics result = employee.stream().collect(Collectors.summarizingDouble(Employee::getSalary));  
		result.getAverage();
		result.getSum();
		
		System.out.println("  " + result.getAverage() + "     "  + result.getSum());
	}
	
	public static void groupBasedAgeMaleNFemale() {
		System.out.println("Q14 Separate age younger n =25 and greater then 25 older ppl ");
		Map<Boolean, List<Employee>>  employeeDetail= employee.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));       
		System.out.println("Result ::: " + employeeDetail.toString());
		
		
		Set<Entry<Boolean, List<Employee>>> entrySet = employeeDetail.entrySet();
		
		for(Entry<Boolean, List<Employee>>  entry : entrySet) {
			
			System.out.println("Depart: " + entry.getKey());
			
			System.out.println("-------------------------------");
			
			List<Employee> empls = entry.getValue();
			
			empls.stream().forEach(e -> System.out.println(e.getName()));
			
			System.out.println("=====================================");
		}
	}
	
	public static void oldestPerson() {
		System.out.println("Q15 oldest Person and his department ");
		Optional<Employee>  employeeDetail= employee.stream().max(Comparator.comparing(Employee::getAge));       
		System.out.println("Result ::: " + employeeDetail.get().getName() + "  Age :: " + employeeDetail.get().getAge());
	}

}
