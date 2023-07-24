package com.test.Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectionsNew {

	public static void main(String[] args) {

		List<Product> productsList = new ArrayList<Product>();

		//Adding Products  
		productsList.add(new Product(1,"HP Laptop",25000f));  
		productsList.add(new Product(2,"Dell Laptop",30000f));  
		productsList.add(new Product(3,"Lenevo Laptop",28000f));  
		productsList.add(new Product(4,"Sony Laptop",28000f));  
		productsList.add(new Product(5,"Apple Laptop",90000f));  
		
		productsList.stream().forEach( a -> System.out.println(a));
		
		
		//1. Set		
	/*	Set<Product> productsSet = productsList.stream().collect(Collectors.toSet());
		
		productsSet.stream().forEach(s -> System.out.println(s));
		*/
		
		
		//2. Map
/*		Map<Integer, String> productM = productsList.stream().collect(Collectors.toMap(Product::getId, Product::getName));
		
		productM.entrySet().stream().forEach(a -> System.out.println(a));
*/		
		
		
		//3. filter

/*		productsList.stream().filter( a -> (a.getName().contains("Apple") || a.getName().contains("Dell"))).forEach(s -> System.out.println(s));;
		
		
		List<String> listSt = Arrays.asList("spring", "network", "test");
		
		List<String> rL = listSt.stream().filter(l -> !"test".equals(l)).collect(Collectors.toList());
		rL.forEach(s -> System.out.println(s));
		*/
          
		List<Project> projects = new ArrayList<Project>();
		
		Project project = new Project("Vzweb", "Pavan");
		Project project1 = new Project("Vzweb1", "Pavan1");
		Project project2 = new Project("Vzweb2", "Pavan2");
		
		Product product = new Product(1, "Mobile", 10);
		Product product1 = new Product(2, "Tv", 20);
		Product product2 = new Product(3, "Tv1", 20);
		
		project.setProduct(product);
		project1.setProduct(product1);
		project2.setProduct(product2);
		
		projects.add(project);
		projects.add(project1);
		projects.add(project2);		
		
		projects.stream().filter( p -> ("Mobile").equals(p.getProduct().getName())).forEach(a -> System.out.println(a.getPname()));
		
		//Optional.ofNullable(projects).stream().filter( m -> ("Mobile").equals(m.getProduct().getName()));
		
		projects.stream().filter( p -> ("Mobile").equals(p.getProduct().getName())).forEach(a -> System.out.println(a.getPname()));
		
		

		
		//.filter().collect(Collectors.toList());
		//.map().collect(Collectors.toList());
		//.stream().collect(Collectors.toList());
		
		//.filter().forEach(a -> sysout(a));
		
		
		
		// flatMap  2d conver as 1 
		
		
		
		String[][] array = new String[][]{{"a","b"},{"c","d"},{"e","f"}};
		
		Stream<String[]> oneDArray =  Arrays.stream(array);
		
		List<String> kResult = oneDArray.flatMap(Stream::of).filter(a -> !a.equals("a")).collect(Collectors.toList());
		
		kResult.forEach(System.out::println);
		
		//.flatMap(Stream::of)
		//.flatMap(Arrays::stream)
		//.flatMap(x -> x.getBooks().stream)
		//.map(a -> a.getBooks).flatMap( x -> x.stream)
		//.flatMapToInt(x -> Arrays.stream(x));
		
		
		Stream<Integer> strInt = Stream.of(1,2,5,7);
		Integer inResu = strInt.map(a -> a*2).reduce(0, Integer::sum);
		System.out.println(inResu);
		
		
		// map().reduce(BigDecimal.ZERO, BigDecimal::add); 
		// map().reduce(0, Integer::sum);
		// map().reduce("", String::concat);
		// map().reduce(0, (a,b) -> a+b);
		// map().reduce(0, (a,b) -> a>b ? a:b);

		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		int max = Arrays.stream(numbers).reduce(0, Integer::max);
		int min = Arrays.stream(numbers).reduce(0, Integer::min);
		int r = Arrays.stream(numbers).reduce(0, (a,b) -> a<b ? a:b);
		
		
		String[] strs = {"a","b","c", " ", "d"};
		
		String str = Arrays.stream(strs).reduce(strs[0], (a,b) -> a +"|" +b);
		
		System.out.println(str);
		
		//remove the empty string
		
		String str2 = Arrays.stream(strs).reduce("", (a,b) -> {  
				if(!"".equals("a")) {
					return a + "|" + b;
				} else {
					return b;
				}			
		});
		System.out.println(str2);
		
		String res = String.join("|", strs);
		System.out.println(res);
		
		//How to get last element of String --  Here use reduce
		
		List<String> strL = Arrays.asList("Java","nodejs","reactjs");
 		
		
		String output = strL.stream().reduce((first,second) -> second).orElse("No Last element");
		
		System.out.println(output);
		
		
		// map, flatMap, filter, sort - returns stream as output.
		
		
		//convert String into Integer
		String val = "10";
		
	//	Optional<Integer> result = Optional.ofNullable(val).filter( );
		
		
		
		
		
		
	//	oneDArray.forEach(System.out::println);
	//	oneDArray.forEach(a -> System.out.println(a));
		
	}
}
