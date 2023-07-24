package com.test.Java8Features;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExamples {

	public static void main(String[] args) {
		// create a stream
		
		Stream<String> stream = Stream.of("a", "b", "c");		
		stream.forEach(System.out::println);
				
		//
		Collection<String> collectionStream = Arrays.asList("Java","J2ee","Spring");
		collectionStream.forEach(System.out::println);
		collectionStream.stream().forEach(System.out::println);
		
		List<String> listStream = Arrays.asList("Java","J2ee","Spring");
		listStream.forEach(System.out::println);
		
		
		Set<String> set = new HashSet<>(listStream);
		set.forEach(System.out::println);
		set.stream().forEach(System.out::println);
		
		String[] strArray = {"a","b","c"};
		Arrays.stream(strArray).forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
