package com.java.core.interviewquestions;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=mOIRNSdar54
public class CoreJavaMain {

	public static void main(String[] args) {
		String input = "1 2 3 5 9 a 6 7 8 4 @ -5 -7 -3 -2 -1";
		
		String[] stringArray = input.split(" ");
		
		List<List<Integer>> sequences = new ArrayList<>();
		
		List<Integer> sequence = new ArrayList<>();
		
		Integer previous = null;
		int count = 0;
		
		for(String s: stringArray) {
		
			try {
				Integer current = Integer.parseInt(s);
				
				if (previous != null) {
					
					if (current-previous == 1) {
						sequence.add(current);
					} else {
						if (sequence.size() > 1) {
							sequences.add(sequence);
						}						
						sequence = new ArrayList<>();
						sequence.add(current);
					}
				} else {
					sequence = new ArrayList<>();
					sequence.add(current);
				}				
				
				previous = current;
				
			} catch (NumberFormatException n) {
				System.out.println("In Exception ::: ");
				if (sequence.size() > 1) {
					sequences.add(sequence);
				}	
				
				sequence = new ArrayList<>();
				previous = null;
				count++;
			}
			System.out.println("Count ::: "+ count++);
			
		}
		if (sequence.size() > 1) {
			sequences.add(sequence);
		}
		System.out.println("Final ::::  " + sequences.toString());
	}
}
