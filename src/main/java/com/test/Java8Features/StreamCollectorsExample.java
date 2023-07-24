package com.test.Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCollectorsExample {

	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();

		//Adding Products  
		productsList.add(new Product(1,"HP Laptop",25000f));  
		productsList.add(new Product(2,"Dell Laptop",30000f));  
		productsList.add(new Product(3,"Lenevo Laptop",28000f));  
		productsList.add(new Product(4,"Sony Laptop",28000f));  
		productsList.add(new Product(5,"Apple Laptop",90000f));  

		List<Float> priceList = productsList.stream().map(a -> a.price).collect(Collectors.toList());

		Set<Float> priceSet = productsList.stream().map(a -> a.price).collect(Collectors.toSet());
		
		double sumPrice = productsList.stream().collect(Collectors.summingDouble(a -> a.price));
		int sumIntPrice = productsList.stream().collect(Collectors.summingInt(a -> a.id));
		double avgPrice = productsList.stream().collect(Collectors.averagingDouble(a -> a.price));
		
		long count = productsList.size();
		long sCount = productsList.stream().collect(Collectors.counting());
		
		System.out.println(priceList);
		System.out.println(priceSet);
		System.out.println(sumPrice);
		
		System.out.println(count);
		System.out.println(sCount);
		
		
		List<Product> priceList2 = productsList.stream().map(a -> {a.price = a.price +2; return a;}).collect(Collectors.toList());
		priceList2.forEach(a -> System.out.println(a.toString()));		
	

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		
		long counts = strings.stream().filter(s -> s.isEmpty()).count();
		long count1s = strings.stream().filter(s -> !s.isEmpty()).count();
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> uniqueNum = numbers.stream().map(a-> a*a).distinct().collect(Collectors.toList());
		Set<Integer> uniqueNumS = numbers.stream().map(a-> a*a).collect(Collectors.toSet());

		
		System.out.println(uniqueNumS);
		System.out.println(uniqueNum);
		
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);
		
		List<String> stringAs = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		
		List<String> result = stringAs.parallelStream().filter(a -> !a.isEmpty()).collect(Collectors.toList());
		
		String resultStr = stringAs.stream().filter(a -> !a.isEmpty()).collect(Collectors.joining(", "));
		
		System.out.println("result : " + resultStr);
		
		
		List numberLs = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();


System.out.println("Highest number in List : " + stats.getMax());
System.out.println("Lowest number in List : " + stats.getMin());
System.out.println("Sum of all numbers : " + stats.getSum());
System.out.println("Average of all numbers : " + stats.getAverage());


	Stream<Date> stream = Stream.generate(() -> {return new Date();});
	//stream.forEach(p -> System.out.println(p));
	
	IntStream intS = "12345_abcdefg".chars();
	intS.forEach(p -> System.out.println(p));
	
	Stream<String> strS = Stream.of("A$B$C$D$E".split("\\$"));
	
	strS.forEach(p -> System.out.println(p));
 	
	//Converting Stream to Array
	 List<Integer> list = new ArrayList<Integer>();
     for(int i = 1; i< 10; i++){
         list.add(i);
     }
     
     Integer[] intArray = list.stream().toArray(Integer[]::new);
	System.out.println(intArray);
	
	//--------------------------------------
	
	List<String> memberNames = new ArrayList<>();
	memberNames.add("Amitabh");
	memberNames.add("Shekhar");
	memberNames.add("Aman");
	memberNames.add("Rahul");
	memberNames.add("Shahrukh");
	memberNames.add("Salman");
	memberNames.add("Yana");
	memberNames.add("Lokesh");
	
	
	memberNames.stream().filter(a -> a.startsWith("A")).forEach(System.out::println);
	memberNames.stream().filter(a -> a.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);;
	memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
	
	//anyMatch, allMatch, noneMatch
	boolean a3 = memberNames.stream().anyMatch(a -> a.startsWith("A"));
	System.out.println(a3);

	boolean a1 = memberNames.stream().allMatch(a -> a.startsWith("A")); // false
	
	System.out.println(a1);
	
	boolean a2 = memberNames.stream().noneMatch(a -> a.startsWith("A")); //false
	System.out.println(a2);
	
	long countT = memberNames.stream().count();
	long countTT = memberNames.stream().filter(a -> a.startsWith("A")).count();
	System.out.println(countTT);
	
	//reduce
	String output = memberNames.stream().reduce( (s1, s2) -> s1 + "#" + s2).get();
	System.out.println(output);
	
	String firstMatchedName = memberNames.stream()
            .filter((s) -> s.startsWith("L"))
            .findFirst().get();

	System.out.println(firstMatchedName);
	
	
	//flatMap
	List<Integer> list1 = Arrays.asList(1,2,3);
	List<Integer> list2 = Arrays.asList(4,5,6);
	List<Integer> list3 = Arrays.asList(7,8,9);
	
	List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
	
	List<Integer> listOfAll = listOfLists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
	
	System.out.println(listOfAll);
	
	
	Integer.valueOf("7");
	
	//Convert to Map
    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "A", 100),
            new Employee(2, "A", 200),
            new Employee(3, "B", 300),
            new Employee(4, "B", 400),
            new Employee(5, "C", 500),
            new Employee(6, "C", 600)));
 //-----------------------------------------------------------------   
    try {
     int x=5, y=10;
    y/=x;
    } catch (Exception e) {
    	System.out.println("Exception ***");
    } finally {
    	System.out.println("Finally ******"); //Ans - Finally will get printed.
    }
    
//---------------------------------------------------------------------
	String[] a11 = {"a", "b"};
	String[] a12 = {"a", "a"};
	String[] a13= {"a"};
	
	int i1 = Arrays.mismatch(a11, a12);
	int i2 = Arrays.mismatch(a12, a13);
	int i3 = Arrays.mismatch(a13, a11);
		
	System.out.println(i1 +" " +i2 +" "+i3);
//------------------------------------------------------------------------
	
	Map<Integer, Employee> emp = employeeList.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
	
	//Peek() - to debug or print element in intermediate stream
	List<Integer> listInt = Arrays.asList(1,2,3,4,5);
	listInt.stream().peek(System.out::println);   // It prints nothing. becuase Peek() on stream on original string, it will not work.
	
	//It works with terminal operator
	List<Integer> newList = listInt.stream().peek(System.out::println).collect(Collectors.toList());
	
	List<String> listOne = Stream.of("11", "12", "11113", "116", "345").collect(Collectors.toList());
	List<String> listTwo = Stream.of("23333", "33", "433", "5").collect(Collectors.toList());
	 
	System.out.println("---------------------------------------------");
//	Optional<String> test 
	
	List<String> test = Stream.of(listOne, listTwo)
	      .peek(System.out::println) //Input
	      .flatMap(x -> x.stream())
	      .peek(System.out::println)  //Output
	      .filter(x -> x.length() > 3)
	      .peek(System.out::println)    // If filter is true, then prints
	      .collect(Collectors.toList());
//	System.out.println("--str--" + test);
	
	
	//Boxed Stream
	List<Integer> ints = IntStream.of(1,2,3,4,5,6,7).boxed().collect(Collectors.toList());
	System.out.println(ints);
	Optional<Integer> max = IntStream.of(1,2,3,4,5,6,7).boxed().max(Integer::compareTo);
	System.out.println(max.get());
	
	List<Long> longs = LongStream.of(1l,2l,3l,4l,5l)
            .boxed()
            .collect(Collectors.toList());
	System.out.println(longs);

	List<Double> listD = DoubleStream.of(1d,2d,3d,4d,5d)
							.boxed()
							.collect(Collectors.toList());	
	
	
	Double avgSal = employeeList.stream()
		      .mapToDouble(Employee::getSalary)
		      .average()
		      .orElseThrow(NoSuchElementException::new);
	
	Vector<String> name = employeeList.stream()
			.map(Employee::getName)
			.collect(Collectors.toCollection(Vector::new));
	
	
	//If-else in Stream --- that means put if-else in Lambda and use that in Stream
	
	//ArrayList<Integer> numberList = 
	
	
	/*Stream Operations
		Intermediate Operations	
			filter()
			map()
			flatMap()
			distinct()
			sorted()
			peek()
			limit()
			skip()
			
		Terminal Operations
			forEach()
			forEachOrdered()
			toArray()
			reduce()
			collect()
			min()
			max()
			count()
			anyMatch()
			allMatch()
			noneMatch()
			findFirst()
			findAny() */
	
	
	
	}
	float getpr(Product p) {
		return p.price;
	}
	
	Product getpr1(Product p) {
		p.price = p.price+2;
		return p;
	}
	
	
	
}
