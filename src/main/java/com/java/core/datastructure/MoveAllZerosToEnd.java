package com.java.core.datastructure;

//https://www.geeksforgeeks.org/move-zeroes-end-array/

public class MoveAllZerosToEnd {


	
	 public static void main(String[] args)
	    {
	        int[] A = { 5, 6, 0, 4, 6, 0, 9, 0, 8 };
	        int n = A.length;
	        int j = 0;
	        for (int i = 0; i < n; i++) {
	        	System.out.println("A[i] "  + " i :" +i  + " - " + A[i]);
	        	System.out.println("A[j] " + " j :" +j  + " - "+A[j]);
	            if (A[i] != 0) {
	                //   Swap - A[j] , A[i]
	                swap(A, j, i); // Partitioning the array
	                j++;
	            }
	        }
	        for (int i = 0; i < n; i++) {
	            System.out.print(A[i] + " "); // Print the array
	        }
	    }
	 
	    // Utility function to swap two elements of an array
	    public static void swap(int[] A, int a, int b)
	    {
	        int temp = A[a];
	        A[a] = A[b];
	        A[b] = temp;
	    }
}
