package com.my.questions.pairAndcourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestPairofStudentsAndCourses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getStudentsIdPairsAndCourses();
		
	}

	

	
	public static void getStudentsIdPairsAndCourses() {
		//1 Input
		
		String[][] enrollments1 = {
	                {"58", "Linear Algebra"},
	                {"94", "Art History"},
	                {"94", "Operating Systems"},
	                {"17", "Software Design"},
	                {"58", "Mechanics"},
	                {"58", "Economics"},
	                {"17", "Linear Algebra"},
	                {"17", "Political Science"},
	                {"94", "Economics"},
	                {"25", "Economics"},
	                {"58", "Software Design"},
	              };
		
		//2 Input
		
		String[][] enrollments2 = {
	          	  {"0", "Advanced Mechanics"},
	          	  {"0", "Art History"},
	          	  {"1", "Course 1"},
	          	  {"1", "Course 2"},
	          	  {"2", "Computer Architecture"},
	          	  {"3", "Course 1"},
	          	  {"3", "Course 2"},
	          	  {"4", "Algorithms"}
	          	};
		
		//3 Input
		
		String[][] enrollments3 = {
				  {"23", "Software Design"},
				  {"3", "Advanced Mechanics"},
				  {"2", "Art History"},
				  {"33", "Another"},
				};
		
		List<List<String>> inputLists = Arrays.stream(enrollments1).map(Arrays::asList).collect(Collectors.toList());
		
		System.out.println("List ::: " + inputLists.toString());
	     
		/*Set<String> uniqueStdIds = new HashSet<>();
		for(List<String> lt: inputLists) {
			
		//	System.out.print(" Inner Obj: " + lt.get(0));
			
			uniqueStdIds.add(lt.get(0));
			
		}
		//	System.out.println(" uniqueStdIds Obj: " + uniqueStdIds.toString());
		*/
	     
		
		Set<String> uniqueStdIdSet =  inputLists.stream().map( f -> f.get(0) ).collect(Collectors.toSet());
		
		studentIdsPair(uniqueStdIdSet, inputLists);
	
		System.out.println(" uniqueStdIds Obj: " + uniqueStdIdSet.toString());

	}
	
	static void studentIdsPair(Set<String> uniqueStdIds, List<List<String>> inputLists) {
		
		List<String> lts = uniqueStdIds.stream().collect(Collectors.toList());
		
		List<String> s = new ArrayList<>();

		for (int i = 0; i < lts.size()-1; i++) {

		//	String integer = lts.get(i);

			for(int j = i+1; j <= lts.size()-1; j++) {

				s.add(lts.get(i) + "," + lts.get(j));
			}
		}
		System.out.println("Pairs ::: " + s.toString());
		getBothPairsNCourse(s, inputLists);
	}
	
	
	static void getBothPairsNCourse(List<String> s, List<List<String>> inputLists) {
		
		Map<String, List<String>> outputValue = new HashMap<>();
		
		
		for (String stdID: s) {
			
			String[] studentIds = stdID.split(",");
			
			System.out.println("First StudentId: " + studentIds[0] + "Second StudentId:  " + studentIds[1]);
			
			//take course for given first student id
			List<String> firstId = inputLists.stream().filter(studentId -> studentId.get(0).equalsIgnoreCase(studentIds[0])).map(course -> course.get(1)).collect(Collectors.toList());
			
			//take course for given second student id
			List<String> secondId = inputLists.stream().filter(studentId -> studentId.get(0).equalsIgnoreCase(studentIds[1])).map(course -> course.get(1)).collect(Collectors.toList());
			
			List<String> commonCourses = firstId.stream().filter(secondId::contains).collect(Collectors.toList());
			
			System.out.println(" commonCourses : " + commonCourses.toString());
			
			outputValue.put(stdID, commonCourses);
		}
		
		System.out.println("Map :::: " + outputValue.toString());
		
		
	}
	
}
