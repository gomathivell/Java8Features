package com.my.questions.pairAndcourse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;

import java.util.stream.Collectors;

import com.my.questions.Employee;



public class TestExample {



	public static void main(String[] args) {

		// TODO Auto-generated method stub



		  

	    List<Student> inputs = new ArrayList<>();

	   inputs.add(new Student("58", "Linear Algebra"));    

	    inputs.add(new Student("94", "Art History"));   

	    inputs.add(new Student("17", "Software Design"));

	     inputs.add(new Student("58", "Mechanics"));

	     inputs.add(new Student("58", "Economics"));

	    inputs.add(new Student("17", "Linear Algebra"));

	    inputs.add(new Student("17", "Political Science"));

	     inputs.add(new Student("94", "Economics"));

	      inputs.add(new Student("25", "Economics"));

	     inputs.add(new Student("58", "Software Design"));

	   

	   

	  Map<String, Map<String, Long>> output = inputs.stream().collect(Collectors.groupingBy(Student::getCourse, Collectors.groupingBy(Student::getId, Collectors.counting())));

	   

	   System.out.println(output);
	   
	   List<StudentAndCourse> andCourses = new ArrayList<>();

	   
	   for(Map.Entry<String, Map<String, Long>>  entry : output.entrySet()) {

		   StudentAndCourse studentAndCourse = new StudentAndCourse();
		   String course = entry.getKey();


		   Map<String, Long> values = entry.getValue();

		   List<String> studentids =  values.entrySet().stream().map( v -> v.getKey()).collect(Collectors.toList());

		   System.out.println("studentids ************** " + studentids.toString());



		   if (studentids.size() <= 1) {
			   studentAndCourse.setPair(studentids.get(0));
		//	   studentAndCourse.setCourse(course);
			   andCourses.add(studentAndCourse);
		   } else {



			   String[] strStudentIds = new String[studentids.size()];
			   for (int i = 0; i < studentids.size(); i++) {
				   strStudentIds[i] = studentids.get(i);
			   }


			   List<String> stuPairs =  getStudentPair(strStudentIds);

			   for (int i = 0; i < stuPairs.size(); i++) {

				   String string = stuPairs.get(i);

				   studentAndCourse = new StudentAndCourse();

				   studentAndCourse.setPair(string);
				   studentAndCourse.setCourse(course);
				   andCourses.add(studentAndCourse);
			   }
		   }

		   System.out.println(" andCourses ::::: " + andCourses.toString());

	   }
	   

	   Map<String, List<String>> s =   andCourses.stream().collect(Collectors.groupingBy(StudentAndCourse::getPair, Collectors.mapping(StudentAndCourse::getCourse, Collectors.toList())));
	   
	   System.out.println("Final One:::: " + s.toString());
	   
	   
	   //findPairs();
	   
	   String[] intResults = {"58","94","17","25"};
	   getStudentPair(intResults);
	   
	   
	   
	   

	}

	public void getStudent() {

		List<Student> inputs = new ArrayList<>();

		inputs.add(new Student("58", "Linear Algebra"));    

		inputs.add(new Student("94", "Art History"));   

		inputs.add(new Student("17", "Software Design"));

		inputs.add(new Student("58", "Mechanics"));

		inputs.add(new Student("58", "Economics"));

		inputs.add(new Student("17", "Linear Algebra"));

		inputs.add(new Student("17", "Political Science"));

		inputs.add(new Student("94", "Economics"));

		inputs.add(new Student("25", "Economics"));

		inputs.add(new Student("58", "Software Design"));



	}

	

	

	public static void findPairs() {

		String[] intResult = {"2","3","5","7"};

		StringBuffer  sb = new StringBuffer();

		List<String> s = new ArrayList<>();


		for (int i = 0; i < intResult.length-1; i++) {


			for(int j = i+1; j <= intResult.length-1; j++) {

				s.add(intResult[i] + "," + intResult[j]);

			}

		}

		System.out.println("Output ::::::: " + s.toString());

	}

	
	
	public static List<String> getStudentPair(String[] intResult) {

	//	String[] intResult = {"2","3","5","7"};
		
		
	//	intResult = intResults;
		
		StringBuffer  sb = new StringBuffer();

		List<String> s = new ArrayList<>();

		for (int i = 0; i < intResult.length-1; i++) {

			String integer = intResult[i];

			for(int j = i+1; j <= intResult.length-1; j++) {

				s.add(intResult[i] + "," + intResult[j]);
			}

		}
		System.out.println("Output ::::::: " + s.toString());
		return s;
	}
	
	

}


