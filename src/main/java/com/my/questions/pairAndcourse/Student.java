package com.my.questions.pairAndcourse;

public class Student {
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
