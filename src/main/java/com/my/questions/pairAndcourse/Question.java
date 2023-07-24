package com.my.questions.pairAndcourse;

public class Question {
	
	
	/*
	You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

	Write a function that takes in a collection of (student ID number, course name) pairs and returns, for every pair of students, a collection of all courses they share.


	Sample Input:

	enrollments1 = [
	  ["58", "Linear Algebra"],
	  ["94", "Art History"],
	  ["94", "Operating Systems"],
	  ["17", "Software Design"],
	  ["58", "Mechanics"],
	  ["58", "Economics"],
	  ["17", "Linear Algebra"],
	  ["17", "Political Science"],
	  ["94", "Economics"],
	  ["25", "Economics"],
	  ["58", "Software Design"],
	]

	Sample Output (pseudocode, in any order):

	find_pairs(enrollments1) =>
	{
	  "58,17": ["Software Design", "Linear Algebra"]
	  "58,94": ["Economics"]
	  "58,25": ["Economics"]
	  "94,25": ["Economics"]
	  "17,94": []
	  "17,25": []
	}



	Additional test cases:

	Sample Input:

	enrollments2 = [
	  ["0", "Advanced Mechanics"],
	  ["0", "Art History"],
	  ["1", "Course 1"],
	  ["1", "Course 2"],
	  ["2", "Computer Architecture"],
	  ["3", "Course 1"],
	  ["3", "Course 2"],
	  ["4", "Algorithms"]
	]



	Sample output:

	find_pairs(enrollments2) =>
	{
	  "1,0":[]
	  "2,0":[]
	  "2,1":[]
	  "3,0":[]
	  "3,1":["Course 1", "Course 2"]
	  "3,2":[]
	  "4,0":[]
	  "4,1":[]
	  "4,2":[]
	  "4,3":[]
	}

	Sample Input:
	enrollments3 = [
	  ["23", "Software Design"],
	  ["3", "Advanced Mechanics"],
	  ["2", "Art History"],
	  ["33", "Another"],
	]


	Sample output:

	find_pairs(enrollments3) =>
	{
	  "23,3": []
	  "23,2": []
	  "23,33":[]
	  "3,2":  []
	  "3,33": []
	  "2,33": []
	}

	All Test Cases:
	find_pairs(enrollments1)
	find_pairs(enrollments2)
	find_pairs(enrollments3)

	Complexity analysis variables:

	n: number of student,course pairs in the input
	s: number of students
	c: total number of courses being offered (note: The number of courses any student can take is bounded by a small constant)
	*/


	/*public class Solution {
	  public static void main(String[] argv) {
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
	      {"58", "Software Design"}
	    };

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

	    String[][] enrollments3 = {
	      {"23", "Software Design"},
	      {"3",  "Advanced Mechanics"},
	      {"2",  "Art History"},
	      {"33", "Another"},
	    };
	   
	   
	    getStudentAndCourse(enrollments1);
	  }
	 
	 
	  public static void getStudentAndCourse(String[][] enrollments1) {
	   
	 
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
	 
	   
	   
	   
	  }
	   
	 
	}



	 
	 
	class Student {
	  private String id;
	  private String course;
	 
	public String getId() {
	return id;
	}
	public void setId(String id) {
	this.id = id;
	}
	public String getCourse() {
	return course;
	}
	public void setCourse(String course) {
	this.course = course;
	}
	public Student(String id, String course) {
	super();
	this.id = id;
	this.course = course;
	}
	@Override
	public String toString() {
	return "Student [id=" + id + ", course=" + course + "]";
	}


	}

}*/
	
}
