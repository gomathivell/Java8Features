package com.test.Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
	
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			myList.add(i);
		}
		
		Stream<Integer> sequentialStream = myList.stream();
		
		Stream<Integer> higherValue =  sequentialStream.filter(p -> p > 90);
		
		higherValue.forEach(System.out::println);
		
		
		//---------------------------------------------------------
		
		
		
	}
}
