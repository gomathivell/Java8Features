package com.my.questions.java8.completablefuture;


public class Employee {
	
	public String employeeId;
    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String newJoiner;
    public String learningPending;
    public String salary;
    public String rating;
    
    public Employee() {
	}
    
	public Employee(String employeeId, String firstName, String lastName, String email, String gender, String newJoiner,
			String learningPending, String salary, String rating) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.newJoiner = newJoiner;
		this.learningPending = learningPending;
		this.salary = salary;
		this.rating = rating;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNewJoiner() {
		return newJoiner;
	}
	public void setNewJoiner(String newJoiner) {
		this.newJoiner = newJoiner;
	}
	public String getLearningPending() {
		return learningPending;
	}
	public void setLearningPending(String learningPending) {
		this.learningPending = learningPending;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
}
