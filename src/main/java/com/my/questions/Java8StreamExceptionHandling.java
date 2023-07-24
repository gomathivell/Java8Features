package com.my.questions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Java8StreamExceptionHandling {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("44", "373", "xyz");
		
	//	list.stream().mapToInt(i -> i).collect(Collectors.toList());
		/*List<Integer> listInt = list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		System.out.println(listInt);*/
		
		//Exception Handling
		list.forEach(s -> {
			try {
				 System.out.println(s);
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		//2 approach 
		list.forEach(Java8StreamExceptionHandling::printList);
		
		//3 approach
		
	}
	
	public static void printList(String s) {
		try {
			 System.out.println(s);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Consumer<String> handleExceptionIfAny(Consumer<String> payload) {
		return obj -> {
			try {
				
			} catch (Exception ex) {
				System.out.println(ex);
			}
		};
	}

}
