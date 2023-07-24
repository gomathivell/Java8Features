package com.my.questions;

import java.util.Arrays;

public class AnagramPrograms {

	public static void main(String[] args) {
             
	}
	
	static boolean areAnagram(char[] str1, char[] str2) {
		int n1 = str1.length;
		int n2 = str2.length;
		
		// if  length is not match then no anagram
		if(n1 != n2) {
			return false;
		}
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		for(int i=0; i<n1; i++) {
			
		}
		
		return true;
	}

}
