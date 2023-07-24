package com.test.sampleEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyTest {

	private static final Object Integer = null;

	public static void main(String[] args) {
		
		String[][] tst = new String[][]{{"A", "1"}, {"A", "2"}, {"B", "9"}, {"C", "10"}};
		//Using Stream print the sum of the index 1 for all the elements where index 0 is "A"
		//Example [["A", "1"], ["B", "1"], ["A", "2"]] result is 3
		
		
		
		Stream st = Stream.of(tst);

	//	st.filter( a -> a[0].equals("A") );
		
	//	Optional<String[]> intA =	Arrays.stream(tst).filter((obj)->obj.equals("A"));
		
	//	Arrays.stream(intA).forEach(a -> System.out.println(a));
		
/*	List<String> ll =	Arrays.stream(tst).flatMap(row -> Stream.of(row))
        .filter((obj)->obj.equals("A")).collect(Collectors.toList());
	
	ll.stream().forEach(a -> System.out.println(a));*/
	
		
		
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);		
		
		
	}

}
