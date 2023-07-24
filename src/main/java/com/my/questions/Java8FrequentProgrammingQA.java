package com.my.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java.core.Employee;
import com.java.core.Product;
import com.my.questions.pairAndcourse.Student;

public class Java8FrequentProgrammingQA {

	public static void main(String[] args) {

		findEachLetterCount();
		
		findDuplicateValue();
		
		findUniqueValue();
		
		findFirstNonRepeatedValue();
		
		findFirstRepeatedValue();
		
		findSecondHighestNumber();
		
		findSecondLowestNumber();
		
		findLongestStringFromArray();
		
		findElementsStartsWithOne();
		
		useJoinMethods();
		useSkipAndLimit();
		getorderNumber();
		System.out.println("==============================================");
		sortListUsingLamba();
		
		getMapSorting();
		getMapSortingForCustomObject();
		
		doMapAndReduce();
		
		System.out.println("==============================================");
		
		findProductCountInDepart();
		
		System.out.println("========================Convert List to Map ======================");
		
		convertListToMap();
		
		
		findSecondHighestNumberWithDuplicate();
		
		find2DimentionElements();
	}
	
	static void findEachLetterCount() {
		// Count of each alphabets - 
				String str = "ilovejavatechie";
				String [] strArray = str.split("");
				//Map<String, List<String>> map =Arrays.stream(str.split("")).collect(Collectors.groupingBy(c -> c));
				Map<String, Long> map = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
				System.out.println("Output :::: " + map);
	}
	
	//find all duplicate alphate in given string
	static void findDuplicateValue() {
		
		String str = "ilovejavatechie";
		String [] strArray = str.split("");
		/*Set<Entry<String, Long>> duplicateVal = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet();*/
		
		//Need to convert Map into SET using  .entrySet() then we get Stream
		
		List<String> duplicateVal = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream()
		.filter( e -> e.getValue() > 1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		
		System.out.println(" " + duplicateVal);
	}
	
	
	//FInd Unique value letter
	static void findUniqueValue() {
		
		String str = "ilovejavatechie";
		String [] strArray = str.split("");
		/*Set<Entry<String, Long>> uniqueValues = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet();*/
		
		//Need to convert Map into SET using  .entrySet() then we get Stream
		
		List<String> uniqueVal = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream()
		.filter( e -> e.getValue() == 1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		
		System.out.println("Unique Elements " + uniqueVal);
	}
	
	
	//Find 
	static void findFirstNonRepeatedValue() {
		//Ans : l
		//here HashMap wont work - it will not maintain insertion order 
		//So in order to have insertion order User LinkedHashMap in Group by
		String str = "ilovejavatechie";
		String[] strArray = str.split("");
		String output = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream()
		.filter( c -> c.getValue() == 1)
		.findFirst().get().getKey();
		
		System.out.println(" findFirstNonRepeatedValue ::: " + output);		
	}
	

	static void findFirstRepeatedValue() {
		//Ans : l
		//here HashMap wont work - it will not maintain insertion order 
		//So in order to have insertion order User LinkedHashMap in Group by
		String str = "ilovejavatechie";
		String[] strArray = str.split("");
		String output = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream()
		.filter( c -> c.getValue() > 1)
		.findFirst().get().getKey();
		
		System.out.println(" findFirstRepeatedValue ::: " + output);		
	}
	
	
	//find second highest number from given array
	static void findSecondHighestNumber() {
		
		int[] numbers = {5, 9, 11, 2, 8, 21, 1};
		
		Integer list = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		System.out.println("List Output :: " + list);
	}
	
	//find second highest number from given array with duplicate
	static void findSecondHighestNumberWithDuplicate() {
		
		int[] numbers = {5, 9, 11, 2, 8, 21, 21, 1};
		
		Integer list = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
		
		System.out.println("List Output :: " + list);
	}
	
	
	//find second lowerest number from given array
	static void findSecondLowestNumber() {
		
		int[] numbers = {5, 9, 11, 2, 8, 21, 1};
		
		//Integer list = Arrays.stream(numbers).boxed().sorted().skip(1).findFirst().get();
		Integer list = Arrays.stream(numbers).sorted().skip(1).findFirst().getAsInt();
		
		System.out.println("List Output : findSecondLowestNumber : " + list);
	}
	
	//find longest string in given array
	//Usign reduce() eaily can identify
	static void findLongestStringFromArray() {
		String[] strArray = {"java", "techie", "springboot", "microservices"};
		
		String word = Arrays.stream(strArray).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
		
		System.out.println("Long Word :: "+ word);
	}
	
	//find all elements from array who starts with 1
	static void findElementsStartsWithOne() {
		int[] numbers = {5, 9, 11, 2, 8, 21, 1, 29};
		
		List<String> strList = Arrays.stream(numbers).boxed().map(s -> s+"")
				.filter(s -> s.startsWith("1"))
				.collect(Collectors.toList());
		System.out.println(strList);
	}
	
	//String.join
	static void useJoinMethods() {
		
		List<String> nos = Arrays.asList("1", "2", "3", "4");
		
		String result = String.join("-", nos);
		
		System.out.println( result);
	}
	
	static void find2DimentionElements() { 
		String[][] enrollments1 = {
	                {"58", "Linear Algebra"},
	                {"94", "Art History"},
	                {"94", "Operating Systems"},
	                {"17", "Software Design"},
	                {"58", "Mechanics"},
	                {"58", "Economics"},
	                {"17", "Linear Algebra"},
	                {"17", "Political Science"},
	                {"94", "Economics"},
	                {"25", "Economics"},
	                {"58", "Software Design"},
	              };
		
		
		
		List<String[]> enrollMents = Arrays.asList(enrollments1);
	/*	
		List<Student> students1 = new ArrayList<>();
		Stream<Object> students2 = enrollMents.stream().map( b -> {
			//String[] b = a[i];
			
			students1.add(new Student(b[0], b[1]));
			return students1;
		});*/
		
		
		List<Student> students = new ArrayList<>();
		
		for (int i = 0; i < enrollments1.length; i++) {
			String[] strings = enrollments1[i];
			students.add(new Student(strings[0], strings[1]));
		}
		
		System.out.println(students.toString());
		
	//	List collection = Arrays.stream(enrollments1).flatMap(Arrays::stream).collect(Collectors.toList());
		
	//	Object s = enrollMents.stream().flatMap(Stream::of).collect(Collectors.toList());		
		
		System.out.println("enrollMents  ::: " + enrollMents.toString());
		
	}
	
	
	//Skip and Limit
	//display 2-9
	static void useSkipAndLimit() {
		IntStream.rangeClosed(1, 10)
		.skip(1)
		.limit(8)
		.forEach(System.out::println);
	}

	// How to Sort the List and Map
	
	//map and flatmap
	
	//Convert List to LinkedArrayList
	static void getorderNumber() {
		
		LinkedList<Integer> lArray = Arrays.asList(5, 3, -3, -4, 0, 2, -1, 4, -7, 2).stream().collect(Collectors.toCollection(LinkedList::new));
		
		LinkedList<Integer> result = lArray.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println("lArray result ::: " + result);
	}
	
	static void getOrderNumberInSameOrder() {
		LinkedList<String> lArray = Arrays.asList(5, 3, -3, -4, 0, 2, -1, 4, -7, 2).stream().map(s -> s+"").collect(Collectors.toCollection(LinkedList::new));
		
	//	lArray.stream().filter( ));
	}
	
	static void sortListUsingLamba() {
		List<Integer> list = new ArrayList<>();
		
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(4);
		
		//Primitive Sorting
		java.util.Collections.sort(list);		
		java.util.Collections.reverse(list);		
		list.stream().sorted().forEach(s -> System.out.println(s));
		list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));
		
		List<Employee> employees = getEmployees();
		java.util.Collections.sort(employees, new MyComparator());
		System.out.println(employees.toString());
		
/*		java.util.Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o2.getSalary()-o1.getSalary());
			}
		});
*/		
		Collections.sort(employees, (o1, o2) ->
			 (int) (o2.getSalary()-o1.getSalary()));
		
		System.out.println("Lamda Reverse Order ::: " + employees.toString());
		
		employees.stream().sorted((o1, o2) ->
		 (int) (o2.getSalary()-o1.getSalary())).forEach(System.out::println);
		
		employees.stream().sorted((o1, o2) ->
		  (o2.getName().compareTo(o1.getName()))).forEach(System.out::println);
		
		System.out.println(" ================================ ");
		employees.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).forEach(System.out::println);
		employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
	}
	
	static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1,"Goms", 20000, "A"));
		employees.add(new Employee(2,"Kalpu", 50000, "B"));
		employees.add(new Employee(3,"Latheesh", 30000, "A"));
		employees.add(new Employee(4,"Reyansh", 60000, "A"));
		employees.add(new Employee(5,"Kalyan", 70000, "B"));
		return employees;
	}
	
	//sorting Map using Lambda Expression
	//Map we do sorting using Key or Value
	static void getMapSorting() {
		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);
	
		List<Entry<String, Integer>> listArray = new ArrayList<>(map.entrySet());
		
		Collections.sort(listArray, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				return o1.getValue()-o2.getValue();
			}
		});
		
		
		Collections.sort(listArray, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
		Collections.sort(listArray, (o1, o2) -> o1.getValue()-o2.getValue());
		System.out.println("==========================================================");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
		for(Entry<String, Integer> entry : listArray ) {			
			System.out.println(entry.getKey() + " -- " + entry.getValue());
		}		
	}
	
	static void getMapSortingForCustomObject() {
		Map<Employee, Integer> employees = new TreeMap(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o2.getSalary()-o1.getSalary());
			}
		});
		
		Map<Employee, Integer> employees1 = new TreeMap<>((o1, o2) ->
		 (int) (o2.getSalary()-o1.getSalary()));
		
		employees.put(new Employee(1,"Goms", 20000,"A"), 60);
		employees.put(new Employee(2,"Kalpu", 50000, "B"), 20);
		employees.put(new Employee(3,"Latheesh", 30000, "B"), 90);
		employees.put(new Employee(4,"Reyansh", 60000, "A"), 50);
		employees.put(new Employee(5,"Kalyan", 70000, "A"),120);
		
		System.out.println(employees);
		
		List<Entry<Employee, Integer>> listOfMap = new ArrayList<>(employees.entrySet());
		listOfMap.stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
		//reversed the above one
		listOfMap.stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);
		
		listOfMap.stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName))).forEach(System.out::println);
		
		//Max
		listOfMap.stream().max(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).get();
		
		//Min
		listOfMap.stream().min(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).get();
		
		
	//	Collections.sort(listOfMap,  (o1, o2) -> o1.getSalary()- o2.getSalary());
		
	//	listOfMap.stream().sorted().forEach(System.out::println);
	}
	
	
	
	static void doMapAndReduce() {
		
		List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);
		
		int sum = 0;
		for(int n: numbers) {
			sum = sum+n;
		}
		System.out.println("Sum : " + sum);
		
		//Boxing - int to Integer
		//Unboxing - mapToInt, mapToFloat, mapToBoolean
		//reduce for all aggregate method - Binary Operation
		
		int sum1 = numbers.stream().mapToInt(i -> i).sum();
		System.out.println("Sum :::: " + sum1);
		
		Integer output = numbers.stream().reduce(0, (a, b) -> a+b);
		System.out.println("Output :::: " + output);
		
		Integer outputOne = numbers.stream().reduce(Integer::sum).get();
		
		Integer maxVal = numbers.stream().reduce(0, (a, b) -> a > b ? a:b);
		System.out.println("Output :::: " + maxVal);
		Integer maxValue = numbers.stream().reduce(Integer::max).get();
		System.out.println("Output :::: " + maxValue);
		
		List<String> words = Arrays.asList("corejava", "Spring", "hibernate");
		
		String longString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
		System.out.println("Long String :::: " + longString);
		
		//get employee whos Grade is A
		//get Salary of all Grade A employee
		OptionalDouble  avg = getEmployees().stream()
		.filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
		.map(emp -> emp.getSalary())
		.mapToDouble(i -> i)
		.average();//.getAsDouble();
		
		System.out.println(avg);
		
		double  sumSal = getEmployees().stream()
				.filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
				.map(emp -> emp.getSalary())
				.mapToDouble(i -> i)
				.sum();
		System.out.println(sumSal);
	}
	
	
	public static void convertListToMap() {
		
		List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        
        
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));
        
		System.out.println("Convert List to Map :::::: " + map.toString());
		
	//	 Map<Integer, String> map1 = list.stream().collect(Collectors.toMap(Hosting::getId, Collectors.toList()));
	}
	
	
	public static void removeDuplicatefromArray() {
		
		int[] input = {1,1,2,2,2,2};
		
		
		
	}
	
	
	static void findProductCountInDepart() {
		List<Product> products = new ArrayList<>();
		products.add(new Product("Milk", 12, "D1"));		
		products.add(new Product("Sugar", 12, "D2"));
		products.add(new Product("Rice", 12, "D2"));
		products.add(new Product("Bread", 12, "D3"));
		products.add(new Product("Cake", 12, "D4"));
		products.add(new Product("Water", 12, "D1"));
		
		Map<String, Long> map = products.stream().collect(Collectors.groupingBy(Product::getDepartment, LinkedHashMap::new, Collectors.counting()));
		
		System.out.println(map);
		
	}
	
}

class MyComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) (o1.getSalary()-o2.getSalary());
	}
	
}
 