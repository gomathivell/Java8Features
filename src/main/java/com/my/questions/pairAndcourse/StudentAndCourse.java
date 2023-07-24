package com.my.questions.pairAndcourse;

public class StudentAndCourse {
	
	private String pair;
	private String course;
	
	public StudentAndCourse() {
		// TODO Auto-generated constructor stub
	}
	public StudentAndCourse(String pair, String course) {
		super();
		this.pair = pair;
		this.course = course;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "StudentAndCourse [pair=" + pair + ", course=" + course + "]";
	}
	
	
	

}
