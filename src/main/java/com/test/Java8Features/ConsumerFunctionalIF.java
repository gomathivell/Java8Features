package com.test.Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalIF {

	public static void main(String[] args) {

		Consumer<Integer> display = a ->System.out.println(a);
		
		display.accept(10);
		
		Consumer<List<Integer>> multiply = list -> {
			
			for (int i = 0; i <list.size(); i++ ) {
				list.get(i);
				
				list.set(i, 2*list.get(i));
			}
		};
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		
		multiply.accept(list);
		
		Consumer<List<Integer>> displayList = list1 -> list1.stream().forEach(a -> System.out.println(a ) );
		displayList.accept(list);
		
		
		//multiply.andThen(displayList).accept(list);
		displayList.andThen(multiply).accept(list);
		
		displayList.andThen(multiply).andThen(displayList).accept(list);
		
	}
	
	

}
