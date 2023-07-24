package com.java.core.datastructure;

//https://www.geeksforgeeks.org/recursion-in-java/
//Recursion - Dynamic Algorithum

public class FactorialRecursion {

	public static void main(String[] args) {
		FactorialRecursion recursion = new FactorialRecursion();
		int result = recursion.fact(5);
		
		System.out.println("Recursion : Result :" + result);
	}

	int fact(int n) {
		
		int result;
		
		if (n == 1) return 1; // This is base condition. Untill reach the base condition the recursion will happen.
		
		result = n*fact(n-1);
		
		return result;
		
	}
}
