package com.my.questions.java8.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		getEmployees();
	}
	
	
	public static List<Employee> getEmployees() throws InterruptedException, ExecutionException {
		
		Executor execute = Executors.newFixedThreadPool(10);
		
		 CompletableFuture<List<Employee>>  listOfEmployee = CompletableFuture.supplyAsync(() -> 
		 {
			 System.out.println("Thread :: " + Thread.currentThread().getName());
			return EmployeeDatabase.fetchListofEmployee();
		 }, execute);
		return listOfEmployee.get();
	}
}
