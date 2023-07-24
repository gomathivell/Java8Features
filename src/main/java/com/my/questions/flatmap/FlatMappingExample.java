package com.my.questions.flatmap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.logicbig.com/how-to/code-snippets/jcode-java-8-streams-collectors-flatmapping.html
public class FlatMappingExample {

	public static void main(String[] args) {
		
		 List<Integer> list = Stream.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8))
                 .collect(
                         Collectors.flatMapping(
                                 l -> l.stream()
                                       .filter(i -> i % 2 == 0),
                                 Collectors.toList()
                         )
                 );
	}

}
