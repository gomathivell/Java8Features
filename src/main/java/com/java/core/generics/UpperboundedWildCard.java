package com.java.core.generics;

import java.util.Arrays;
import java.util.List;

public class UpperboundedWildCard {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(5, 20, 25);
		
		System.out.println(sumOfNumbers(intList));
		
		List<Double> doubleList = Arrays.asList(5.0, 20.0, 25.0);
		
		System.out.println(sumOfNumbers(doubleList));
	}
	
	public static double sumOfNumbers(List<? extends Number> lists) {
		double sum = 0.0;
		for(Number list : lists) {
			
			sum += list.doubleValue();
		}
		
		return sum;
	}
	
}

