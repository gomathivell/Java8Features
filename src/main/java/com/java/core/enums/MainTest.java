package com.java.core.enums;

public class MainTest {
	
	public enum colours {
		Red, Yellow, Green
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		colours[] obj = colours.values();
		
		for (colours col : obj) {
			System.out.println(" Colours :: " + col);
		}
	}

}
