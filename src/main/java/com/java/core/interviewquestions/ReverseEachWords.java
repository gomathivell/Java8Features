package com.java.core.interviewquestions;

import java.util.Arrays;
import java.util.stream.Collectors;
//https://tutorialcup.com/interview/string/reverse-individual-words.htm
public class ReverseEachWords {

	public static void main(String[] args) {
		 String s = "TutorialCup - changing the way of learning";
	     revWords(s); 
	     
	     revWordsWithChatAt(s);
	}

	// best performance O(n)
	static void revWords(String s) {
		String output = Arrays.asList(s.split(" ")).stream()
		.map( w -> new StringBuilder(w).reverse())
		.collect(Collectors.joining(" "));
		
		
		System.out.println("output :: " + output);
	}
	
	// take one word and reverse it and for space, for second word take empty "s" and start reverse it.
	static void revWordsWithChatAt(String str) {
		String s = "";
		
		for(int i = 0; i < str.length(); ++i) { 
			if(str.charAt(i) != ' '){ 
				s = str.charAt(i)+s;
			}

			else { 
				System.out.print(s+" ");
				s = "";
			} 
		} 
		System.out.print(s); 
	} 
	      

}
