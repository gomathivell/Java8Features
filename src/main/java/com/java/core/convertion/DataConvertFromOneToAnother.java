package com.java.core.convertion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://stackoverflow.com/questions/4401850/how-to-create-a-multidimensional-arraylist-in-java

public class DataConvertFromOneToAnother {

	public static void main(String[] args) {

		//1 Convert String[] into ArrayList
		String[] stringArray =  {"a", "b", "c"};
		
		List<String> stingList = Arrays.asList(stringArray);
		
		System.out.println(stingList);
		
		
		//2 Convert String[] into Set
		
		Set<String> stringSet = new HashSet<>(Arrays.asList(stringArray));
		
		System.out.println("stringSet : " + stringSet);
		
		
		System.out.println(" =======================");
		dubleArray();
		
	}
	
	
	public static void dubleArray() {
		
		String[][] names = { {"John", "Smith"}, 
							 {"Javin", "Paul"}, 
							 {"James", "Gosling"}, 
						   };

		for (int i = 0; i < names.length; i++) {
			
			for (int j = 0; j < names[i].length; j++) {				
				
				System.out.println(" " + names[i][j]);
				
			}
		}
	}
	
	//https://stackoverflow.com/questions/11447780/convert-two-dimensional-array-to-list-in-java
	
	//Convert 2 dimentional Array into List using Stream
	

}
