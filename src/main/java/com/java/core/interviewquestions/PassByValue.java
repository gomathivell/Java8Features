package com.java.core.interviewquestions;

public class PassByValue {

	public static void main(String[] args) {
		Balloon red = new Balloon("Red");
		Balloon blue = new Balloon("Blue");
		swap(red, blue);
		
		System.out.println("Red Colour: : " + red.getColour());
		System.out.println("Blue Colour: : " + blue.getColour());
	}
	
	public static void swap(Object obj1, Object obj2) {
		Object temp = obj1;
		obj1 = obj2;
		obj2 = temp;		
	}

}
