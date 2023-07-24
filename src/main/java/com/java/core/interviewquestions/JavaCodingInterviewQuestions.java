package com.java.core.interviewquestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://www.digitalocean.com/community/tutorials/java-programming-interview-questions
//https://www.digitalocean.com/community/tutorials/java-tricky-interview-questions
public class JavaCodingInterviewQuestions {

	public static void main(String[] args) {


		String output = reverse("123");
		System.out.println("Output ::: " + output);


		swapNumbersWithOuttemp(10, 20);

		findVowelsInString("hello");
		findVowelsInString("TV");

		System.out.println(findPrimeOrNot(19));
		System.out.println(findPrimeOrNot(48));

		fibanaciSequence(5);


		//Need to call recursion in for loop to print it.
		printFibanaci(5);

		List<Integer> input = new ArrayList<>();
		input.add(5);
		input.add(7);
		input.add(9);
		boolean isAllOdd = isOddNumber(input);
		System.out.println("isAllOdd :::: " + isAllOdd);

		boolean isAllOddByStream = isOddNumberStream(input);
		System.out.println("isAllOdd :Stream ::: " + isAllOddByStream);
		
		
		boolean isPalindrome = isPalindrome("MoM");
		System.out.println("isPalindrome ::: " + isPalindrome);
		
		//trim - only removes beginning and end
		removeSpace("Hi Goms");
		
		sortArray();
		
	//	guessOutput();
		
		sumAllElements();
		
		findSecondLargestNumberInArray();
//		shuffleArray();
		mergeTwoArrays();
		
		sortByValue();
		
		removeAChar();
		
		distinctCharNCount();
		
		isStringImmutable();
		
		
		//17
		Integer[] a1 = {1,2,3,2,1};
		Integer[] a2 = {1,2,3};
		Integer[] a3 = {1,2,3,4};
		
		System.out.println(sameElements(a1, a2));
		System.out.println(sameElements(a1, a3));
		// end 17
		
		
	}

	//1. How do you reverse a string in Java?
	public static String reverse(String inputString) {
		StringBuilder builder = new StringBuilder();

		char[] chars = inputString.toCharArray();

		for(int i=chars.length-1; i >=0 ; i-- ) {

			builder.append(chars[i]);
		}
		return builder.toString();
	}

	//2. How do you swap two numbers without using a third variable in Java?
	public static void swapNumbersWithOuttemp(int a, int b) {

		System.out.println( "Before "+ "a :" + a + " b: " + b);

		a = a+b;
		b = a-b;
		a = a-b;

		System.out.println("After "+ "a :" + a + " b: " + b);		
	}

	//3. Write a Java program to check if a vowel is present in a string.

	public static void findVowelsInString(String input) {
		boolean isTrue = input.toLowerCase().matches(".*[aeiou].*");
		System.out.println("Is Input has Vowels in it ?? :: " + isTrue);
	}

	//4. Write a Java program to check if the given number is a prime number.
	public static boolean findPrimeOrNot(int n) {

		if (n==0 || n==1) {
			return false;
		}

		if (n==2) return true;

		for(int i=2; i<=n/2 ; i++) {
			if( n%i==0) return false;
		}

		return true;		
	}

	//5. Write a Java program to print a Fibonacci sequence using recursion.
	public static void fibanaciSequence(int count) {
		int a = 0;
		int b = 1;
		int c = 1;

		// a, b, c=a+b

		for(int i = 1; i <= count; i++) {
			System.out.print(a + ", ");

			a=b;
			b=c;
			c=a+b;
		}
	}


	//5.a Write a Java program to print a Fibonacci sequence using recursion.
	public static int fibanaciRecursion(int count) {

		if (count <= 1) return count;

		return fibanaciRecursion(count-1) + fibanaciRecursion(count-2); 

	}

	public static void printFibanaci(int count) {

		for(int i=0; i<count; i++) {
			System.out.println(fibanaciRecursion(i) + " ");
		}

	}

	//6. How do you check if a list of integers contains only odd numbers in Java?
	public static boolean isOddNumber(List<Integer> input) {

		for (Integer eachValue: input) {
			if(eachValue%2 == 0) return false; 
		}
		return true;
	}


	//6a. How do you check if a list of integers contains only odd numbers in Java? - Using Stream Parallel
	public static boolean isOddNumberStream(List<Integer> input) {

		return input.stream().parallel().anyMatch(n -> n%2 != 0);
	}

	
	//7. How do you check whether a string is a palindrome in Java?
	public static boolean isPalindrome(String input) {
		
		char[] inputString = input.toCharArray();
		
		int lastLength = inputString.length-1;
		
		for(int i = 0; i< inputString.length/2; i++) {
			if ( inputString[i] != inputString[lastLength-i] ) {
				return false;
			}
		}
		
		return true;
	}
	
	
	//8. How do you remove spaces from a string in Java?
	public static void removeSpace(String input) {
		String output = input.trim();  //9. remove space in front and back
		
		char[] inChar = input.toCharArray();
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i <inChar.length; i++) {
			if(!Character.isWhitespace(inChar[i])) {
				builder.append(inChar[i]);
			}
		}
		System.out.println("" + builder.toString());
	}

	//10. How do you sort an array in Java?
	public static void sortArray() {
		int[] array = {1, 2, 3, -1, -2, 4};
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	//12. How can you find the factorial of an integer in Java?
	public static long factorial(long n) {
		if (n == 1)
			return 1;
		else
			return (n * factorial(n - 1));
	}

	//13. How do you reverse a linked list in Java?
	public static void linkedList() {
		LinkedList<Integer> inputLinkedList = new LinkedList<>();
		inputLinkedList.add(1);
		inputLinkedList.add(2);
		inputLinkedList.add(3);
		
		System.out.println(inputLinkedList);
		
		LinkedList<Integer> newLinkedList = new LinkedList<>();
		
		inputLinkedList.descendingIterator().forEachRemaining(newLinkedList::add);
		System.out.println(newLinkedList);
	}
	
	
	
	//17. Write Java program that checks if two arrays contain the same elements.
	
	static boolean sameElements(Object[] array1, Object[] array2) {
		
		Integer[] a1 = {1,2,3,2,1};
		Integer[] a2 = {1,2,3};
		Integer[] a3 = {1,2,3,4};
		
		/*System.out.println(sameElements(a1, a2));
		System.out.println(sameElements(a1, a3));*/
		
		Set<Object> uniqueElements1 = new HashSet<>(Arrays.asList(array1));
		Set<Object> uniqueElements2 = new HashSet<>(Arrays.asList(array2));
		
		if (uniqueElements1.size() != uniqueElements1.size()) return false;
		
		for ( Object  object : uniqueElements1) {
			if(!uniqueElements2.contains(object)) return false;
		}
		
		return true;
	}

	
	
	
	
	//18. How do you get the sum of all elements in an integer array in Java?
	
	public static void sumAllElements() {
		int[] array = { 1, 2, 3, 4, 5 };
		
		int sum = 0;
		for(int in: array) {
			sum += in;
		}
		
		System.out.println("Sum :: " + sum);
				
		//Java Stream - 
		System.out.println("Java Stream :: " + 	Arrays.stream(array).sum());
		
		
		
		
	}
	
	//19. How do you find the second largest number in an array in Java?
	
	public static void findSecondLargestNumberInArray() {
		int[] array = { 1, 2, 3, 4, 5 };
		
		//Stream
		Integer out = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("Second Highest :: " + out);
		
		
		//looping		
		int highest = 0;
		int secondHighest = 0;
		for (int i : array) {
			
			if(i > highest) {
				secondHighest = highest;
				highest = i;
			} else if(i > secondHighest) {
				secondHighest = i;
			}
		}
		
		System.out.println("First Highest: " + highest);
		System.out.println("Second Highest: " + secondHighest);
	}
	
	//20. How do you shuffle an array in Java?  - using Random class
	public static void shuffleArray() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		Random random = new Random();
		for(int i : array) {
			//it returns random number from 0 to 7
			int randomIndexToSwap = random.nextInt(array.length);
			
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}
		System.out.println(Arrays.toString(array));
	}
	
	//21. How can you find a string in a text file in Java? -- using Scanner and contain	
	public static boolean findStrinInFile(String filePath, String strValue) throws FileNotFoundException {
		
		File file = new File(filePath);
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext()) {
			
			String line = scanner.nextLine();
			if (line.contains(strValue)) {
				
				return true;
			}
		}
		scanner.close();
		return false;
	}
	
	
	//23. How do you merge two lists in Java?
	public static void mergeTwoArrays() {
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("3");
		List<String> list2 = new ArrayList<>();
		list2.add("2");
		
		list1.addAll(list2);
		
		System.out.println("List1 ::: " + list1);
	}
	
	
	//24. Write a Java program that sorts HashMap by value.
	
	public static void sortByValue() {
		Map<String, Integer> scores = new HashMap<>();

		scores.put("David", 95);
		scores.put("Jane", 80);
		scores.put("Mary", 97);
		scores.put("Lisa", 78);
		scores.put("Dino", 65);

		System.out.println(scores);

		scores = sortByValue(scores);

		System.out.println(scores);
		
		System.out.println("********************************************************************");
		
		sortByValueByStream(scores);
		
	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> scores) {
		Map<String, Integer> sortedByValue = new LinkedHashMap<>();

		// get the entry set
		Set<Entry<String, Integer>> entrySet = scores.entrySet();
		System.out.println(entrySet);

		// create a list since the set is unordered
		List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
		System.out.println(entryList);

		// sort the list by value
		entryList.sort((x, y) -> x.getValue().compareTo(y.getValue()));
		
		System.out.println(entryList);

		// populate the new hash map
		for (Entry<String, Integer> e : entryList)
			sortedByValue.put(e.getKey(), e.getValue());

		return sortedByValue;
	}
	
	
	//Stream using Map.value sorting
	private static void sortByValueByStream(Map<String, Integer> scores) { 
		scores.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
	}
	
	
	//25. How do you remove all occurrences of a given character from an input string in Java? -- replace
	
	public static void removeAChar() {
		String str1 = "abcdABCDabcdABCD";
		
		str1 = str1.replace("a", "");
		
		System.out.println("Output ::: " + str1);
	}
	
	
	
	//26. How do you get distinct characters and their count in a string in Java?
	public static void distinctCharNCount() {
		
		String str1 = "abcdABCDabcd";
		
		Map<Character, Integer> result = new HashMap<>();
		
		char[] charArrays = str1.toCharArray();
		
		for(char in: charArrays) {
			if( result.containsKey(in)) {
				result.put(in, result.get(in)+1);
			} else {
				result.put(in, 1);
			}
		}
		System.out.println("result :: " + result.toString());
		
		
		
		//Stream
		Map<String, Long> mapResult = Arrays.stream(str1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("mapResult :: " + mapResult.toString());
	}
	
	//27. Can you prove that a String object in Java is immutable programmatically?
	public static void isStringImmutable() {
		String s1 = "Java";
		String s2 = s1;
		
		System.out.println(s1==s2);
		
		s1 = "python";
		
		System.out.println(s1==s2);
	}
	
	//29. How do you show a diamond problem with multiple inheritance in Java?
	
	/*interface I {
		void foo();
	}
	class A implements I {
		public void foo() {}
	}

	class B implements I {
		public void foo() {}
	}

	class C extends A, B { // won't compile
		public void bar() {
			super.foo();
		}
	}*/
	
	
	
	
	
	//32. How do you create a record in Java?
	
	/*public record EmpRecord(int id, String name, long salary) {
		
	}*/


	
	
	
	
	//33. How do you create text blocks in Java?
	
	/*public static void text() {
		String textBlock = """
				Hi
				Hellow
				""";
	}*/
	
	
	
	//	34. Show an example of switch expressions and multi-label case statements in Java.
	
	/*
	public static void switchExample() {
		int choice = 2;
		
	int result = switch(choice) {
		case 1,2,3:
				yield choice;
			default:
				yield -1;
		}
	System.out.println("x = " + x); // x = 2
	}
	*/
	//You can also use lambda expressions in switch expressions.
	/*String day = "TH";
	String result = switch (day) {
	    case "M", "W", "F" -> "MWF";
	    case "T", "TH", "S" -> "TTS";

	    default -> {
		    if (day.isEmpty())
			    yield "Please insert a valid day.";
		    else
			    yield "Looks like a Sunday.";
	    }
	};

	System.out.println(result); // TTH
*/	
	
	
	
	//36. How do you create an enum in Java?
	
	public enum ThreadState {
		START,
		RUNNING,
		WAITING,
		DEAD
	}
	
	//39. How do you create a functional interface?
	@FunctionalInterface
	interface Foo {
		void test();
	}
	
	
	
	public static void guessOutput() {
		//42
		
		String s1 = "abc";
		String s2 = "abc";

		System.out.println("s1 == s2 is:" + s1 == s2);  //false
		
		//43
		
		String s3 = "JournalDev";
		int start = 1;
		char end = 5;

		System.out.println(s3.substring(start, end)); // ourna
		
		
		//44
		
		HashSet shortSet = new HashSet();

		for (short i = 0; i < 100; i++) {
			shortSet.add(i);			
			shortSet.remove(i - 1);
		}

		System.out.println(shortSet.size()); //100
		/*The size of the shortSet is 100. The autoboxing feature in Java means that the expression i,
		 *  which has the primitive type short, converts to a Short object. Similarly, 
		 *  the expression i - 1 has the primitive type int and is autoboxed to an Integer object.
		 *   Since there is no Integer object in the HashSet, nothing is removed and the size is 100.*/		
		
		
		
		//45 .
		boolean flag =true;
		try {
			if (flag) {
		  		while (true) {
		   		}
		   	} else {
		   		System.exit(1);
		   	}
		} finally {
		   	System.out.println("In Finally");
		}
		
		/*No output. This code results in an infinite loop if the flag is true and the program exists if the flag is false. 
		 * The finally block will never be reached.*/
		
		
		//46
		
		//47
		String x = "abc";
		String y = "abc";

		x.concat(y);

		System.out.print(x); //abc
		/*The x.concat(y) creates a new string but is not assigned to x, so the value of x is not changed.*/
		
		
		//48
		/* public class MathTest {
		 	public void main(String[] args) {  		
		   		int x = 10 * 10 - 10;
		   		
		   		System.out.println(x);
		   	}		   
		}
		Error: Main method is not static in class MathTest, please define the main method as:
			   public static void main(String[] args) */
		
		
		//49
		
		/*public static void test(String[] args) {
	   		try {
	   			throw new IOException("Hello");
	   		} catch(IOException | Exception e) {
	   			System.out.println(e.getMessage());
	   		}
	   	}*/
		/*This code results in a compile time error. The exception IOException is already caught by the alternative Exception.*/
	}
	
	
	
	
	//50. Find 5 mistakes in the following code snippet.
	
	/*
	package com.digitalocean.programming-interviews;

	public class String Programs {

		static void main(String[10] args) {
			String s = "abc"
			System.out.println(s);
		}
	}
	
	Answers
		The package name can’t have hyphens.
		The class name can’t have spaces.
		The main method is not public, so it won’t run.
		The main method argument shouldn’t specify the size.
		The semicolon is missing in the string definition.
	*/
	
	
	
	// https://www.digitalocean.com/community/tutorials/java-tricky-interview-questions
	//51 . According to Java specs, in case of overloading, the compiler picks the most specific function. Obviously String class is more specific than Object class, hence it will print “String argument”. But, what if we have another method in the class like below.
		public static void main1(String[] args) {
			foo(null);
		}
		public static void foo(Object o) {
			System.out.println("Object argument");
		}
		public static void foo(String s) {
			System.out.println("String argument");  // this will be called
		}
		
		//the below method provides ambiguity 
		/*public static void foo(StringBuffer i){
			System.out.println("StringBuffer impl");
		}*/
}
