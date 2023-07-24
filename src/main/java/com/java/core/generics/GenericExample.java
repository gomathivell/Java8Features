package com.java.core.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

	public static void main(String[] args) {

		IntegerCounter intCounter = new IntegerCounter(1);
		intCounter.print();


		DoubleCounter doubleCounter = new DoubleCounter(1.1);
		doubleCounter.print();


		// we cannot pass the primitive types to generic		
		Counter<Integer> iCounter = new Counter<Integer>(2);		
		iCounter.print();

		Counter<Double> dCounter = new Counter<Double>(2.0);		
		dCounter.print();

		/*Counter<String> strCounter = new Counter<String>("2");		
		strCounter.print();*/

		ArrayList<Integer> inArray = new ArrayList<>();
		inArray.add(1);

		//method generic
/*		print(1);
		print("Latheesh");

		print(1, 2);
		print("Latheesh", "Gomathi");
*/
		
		//List as arguments
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		
		//List<Integer> is not List<Object> , so using ? wildcard 
		print(intList);
		
		
		//List<? extends Number> 
	//	List<String> intList1 = new ArrayList<>();
		List<Integer> intList1 = new ArrayList<>();
		intList1.add(1);
		print(intList1);
	}

	/*// 1 Generic in methods

	private static <T> void print(T t) {

		System.out.println(t);

	}

	// 2 Generic in methods
	private static <T, U> void print(T t, U u) {

		System.out.println(t);
		System.out.println(u);
	}*/

	/*private static void print(List<?> list) {

		System.out.println(list);
	}*/
	
	
	private static void print(List<? extends Number> list) {
		System.out.println(list);
	}
}
