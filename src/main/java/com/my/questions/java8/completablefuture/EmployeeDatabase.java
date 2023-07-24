package com.my.questions.java8.completablefuture;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDatabase {
	
	public static void main(String[] args) {
		fetchListofEmployee();
	}
	
	public static List<Employee> fetchListofEmployee() {
		
		ObjectMapper mapper = new ObjectMapper();
	
		try {
			return mapper.readValue(new File("employees.json"), new TypeReference<List<Employee>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
