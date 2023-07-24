package com.my.questions;

import java.util.Arrays;

public class InterviewQASortNumbersBySameOrder {

	//Output - 5 3 0 2 4 2 -3 -4 -1 -7 
	
	public static void main(String[] args) {
		int[] intValue = { 5, 3, -3, -4, 0, 2, -1, 4, -7, 2 };
		
		String[] strings = Arrays.stream(intValue).mapToObj(String::valueOf).toArray(String[]::new);
		
		System.out.println(Arrays.toString(strings));
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < strings.length; i++) {
			if(strings[i].contains("-")) {
				sb1.append(strings[i] + " ");
			} else {
				sb2.append(strings[i] + " ");
			}			
		}
		System.out.println("Result :::::::::  sb1 : "+sb1.toString());
		System.out.println("Result :::::::::  sb2 : "+sb2.toString());
		
		sb2 = sb2.append(sb1);
		
		System.out.println("Result :::::::::  sb2 : " + sb2.toString());
	}
	
}
