package com.my.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8TwoDimenstionalLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] names = { {"Sam", "Smith"},
                {"Robert", "Delgro"},
                {"James", "Gosling"},
              };
		
		Stream.of(names).map(Arrays::toString).forEach(System.out::println);
		
		
		get2DimenstalArrayByNestedLoop();
	}
	
	
	public static void get2DimenstalArrayByNestedLoop() {
		//https://stackoverflow.com/questions/30065577/how-to-loop-and-print-2d-array-using-java-8
		String[][] names = { {"Sam", "Smith"},
                {"Robert", "Delgro"},
                {"James", "Gosling"},
              };
		
		
		Arrays.stream(names).forEach((i) -> {
	        Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
	        System.out.println();
	    });
		
		
	}
	
	
	static void get2Listfrom2DimenstionalArray() {
		
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
		
		List<List<String>> inputLists = Arrays.stream(enrollments1).map(Arrays::asList).collect(Collectors.toList());
	}
	
	static void getIntArray() {
		
		int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		
		IntStream stream = Arrays.stream(arr).flatMapToInt(x -> Arrays.stream(x));
	}

}
