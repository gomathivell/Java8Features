package com.my.questions.groupingandsorting;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://www.javaprogramto.com/2021/02/%20java-8-groupingby-collector.html
public class GroupBy5DifferenyCategory {

	public static void main(String[] args) { 
		groupingByCounting();
		
		System.out.println("------------------------------------------");
		
		gorupByCountingSorting();
		
		System.out.println("------------------------------------------");
		
		gorupByCountingDescendingSorting();
		
		System.out.println("------------------------------------------");
		
		gorupByReducing();
		
		System.out.println("------------------------------------------");
		groupingByMultipleFields();
	}
	
	public static void groupingByCounting() {
		// Creating List and adding duplicate values. 
				List<String> strings = new ArrayList<>();

				strings.add("Hello");
				strings.add("Ram");
				strings.add("Hello");
				strings.add("Sam");
				strings.add("Hello");
				strings.add("Yam");
				strings.add("Hello");
				strings.add("Raj");
				strings.add("Hello");
				strings.add("Raj");

				// Grouping by based on the count
				Map<String, Long> countMap = strings.stream()
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
				// printing the count of each string using groupingBy() 
				System.out.println("Count :::: "+countMap);
	}
	
	//Group by Name and Group by Quantity and count of quantity
	//find each company's each quantity's count
	public static void groupingByMultipleFields() {
		List<Stock> stocks = new ArrayList<>();

		stocks.add(new Stock("JP Morgan", 20, 100));
		stocks.add(new Stock("ICICI", 20, 100));
		stocks.add(new Stock("HDFC", 30, 300));
		stocks.add(new Stock("ICICI", 20, 200));
		stocks.add(new Stock("JP Morgan", 10, 100));
		stocks.add(new Stock("JP Morgan", 10, 100));

		// group by - stock name + quanity
		
		
		Map<String, Map<Integer, Long>> s = stocks.stream().collect(Collectors.groupingBy(Stock::getName, Collectors.groupingBy(Stock::getQuantity, Collectors.counting())));
		
		System.out.println("Result :::::::::: " + s.toString());
	}
	
	//Group by Name and find total of Quantity
	//Find each company total Quantity
	public static void gorupByReducing() {

		// Creating List and adding duplicate values.
		List<Stock> stocks = new ArrayList<>();

		stocks.add(new Stock("JP Morgan", 10));
		stocks.add(new Stock("ICICI", 10));
		stocks.add(new Stock("HDFC", 10));
		stocks.add(new Stock("ICICI", 10));
		stocks.add(new Stock("JP Morgan", 10));
		stocks.add(new Stock("JP Morgan", 10));

		// group by - stock name + sum(quanity)
		
		
		Map<String, Integer> result = stocks.stream().collect(Collectors.groupingBy(Stock::getName, Collectors.summingInt(Stock::getQuantity)));
		System.out.println("Summing :: " + result.toString());
		
	}
	
	// find the each Name's count and print in count (ascending order) order
	public static void gorupByCountingSorting() {

		// // Creating List and adding duplicate values.
		List<String> strings = new ArrayList<>();

		strings.add("Hello");
		strings.add("Ram");
		strings.add("Hello");
		strings.add("Sam");
		strings.add("Hello");
		strings.add("Yam");
		strings.add("Hello");
		strings.add("Raj");
		strings.add("Hello");
		strings.add("Raj");

		// Grouping by based on the count
		
		Map<String, Long> s = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("Name List :: without Order :: " + s.toString());
		
		//Order by counting
		Map<Object, Object> output = s.entrySet().stream()
									  .sorted(Map.Entry.comparingByValue())
									  .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
		
		//Order by Name alphabet
		/*Map<Object, Object> output = s.entrySet().stream()
				  .sorted(Map.Entry.comparingByKey())
				  .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));*/
		
		System.out.println("Name List :: " + output.toString());
		
	}

	
	public static void gorupByCountingDescendingSorting() {
		// // Creating List and adding duplicate values.
				List<String> strings = new ArrayList<>();

				strings.add("Hello");
				strings.add("Ram");
				strings.add("Hello");
				strings.add("Sam");
				strings.add("Hello");
				strings.add("Yam");
				strings.add("Hello");
				strings.add("Raj");
				strings.add("Hello");
				strings.add("Raj");
				
				
				Map<String, Long> countMap2 = strings.stream()
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
				Map<String, Long> finalMapDescendingOrder = new LinkedHashMap<>();
				
				countMap2.entrySet().stream()
						 .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
						 .forEachOrdered( e -> finalMapDescendingOrder.put(e.getKey(), e.getValue()));
				
				System.out.println("gorupByCountingDescendingSorting :::::: " + finalMapDescendingOrder.toString());
	}
	
	
}
