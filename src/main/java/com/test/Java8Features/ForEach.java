package com.test.Java8Features;

import java.util.ArrayList;
import java.util.List;

public class ForEach {

	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<Integer>(); 
		
		for(int i=0; i<10; i++) 
			myList.add(i);
		
		MyConsumer consumer = new MyConsumer(); 
		
		myList.forEach(consumer);
		

	}

}
