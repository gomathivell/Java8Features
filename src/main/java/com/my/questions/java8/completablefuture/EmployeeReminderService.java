package com.my.questions.java8.completablefuture;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class EmployeeReminderService {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		EmployeeReminderService reminderService = new EmployeeReminderService();
		reminderService.sendReminderToEmployee().get();
	}

	
	public static CompletableFuture<Void> sendReminderToEmployee() {
		//If you use same thread pool, then all thread comes from same pool
		Executor execute = Executors.newFixedThreadPool(5);
		
		//If you use different executor, then different pools will product different thread
/*		Executor execute1 = Executors.newFixedThreadPool(5);
		Executor execute2 = Executors.newFixedThreadPool(5);
*/		
		CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
			
			System.out.println("Thread :: " + Thread.currentThread().getName());
			
			return EmployeeDatabase.fetchListofEmployee();
		}, execute).thenApplyAsync((employees) -> { 
			
			System.out.println("Thread new Joiner employee :: " + Thread.currentThread().getName());
			
			return employees.stream()
							.filter(employee -> "TRUE".equalsIgnoreCase(employee.getNewJoiner()))
							.collect(Collectors.toList());
							
		}, execute).thenApplyAsync((employees) -> {
			System.out.println("Thread Learning Pending employee :: " + Thread.currentThread().getName());
			
			return employees.stream()
							.filter(employee -> "TRUE".equalsIgnoreCase(employee.getLearningPending()));
		}, execute).thenApplyAsync((employees) -> {
			System.out.println("Thread Employee Email Id employee :: " + Thread.currentThread().getName());
			return employees.map(Employee::getEmail).collect(Collectors.toList());
		//	return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
		}, execute).thenAcceptAsync((emails) -> {
			System.out.println("Thread Employee Send employee :: " + Thread.currentThread().getName());
			emails.forEach(EmployeeReminderService::sendEmail);
		}, execute);
		
		
		return completableFuture;
		
		
		
	}
	
	
	public static void sendEmail(String emailId) {
		
		System.out.println("Sending remainfder in email .................." + emailId);
		
	}
}
