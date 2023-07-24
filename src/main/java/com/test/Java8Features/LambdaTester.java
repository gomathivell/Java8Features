package com.test.Java8Features;

public class LambdaTester {
	final static String salutation = "Hello !";

	public static void main(String[] args) {
		LambdaTester tester = new LambdaTester();
		MathOperation addition = (int a, int b) -> { return a+b; };
		
		MathOperation subtraction = (a, b) -> a-b ;
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		
		GreetingService greetingService = message -> System.out.println(salutation + message);
		greetingService.sayMessage("Msg2");
	}

	interface MathOperation {
		int operation(int a, int b);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
	interface GreetingService {
		void sayMessage(String message);
	}
}
