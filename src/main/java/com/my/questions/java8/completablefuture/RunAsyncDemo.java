package com.my.questions.java8.completablefuture;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RunAsyncDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RunAsyncDemo asyncDemo = new RunAsyncDemo();
		asyncDemo.saveEmployees(new File("employees.json"));
		
		asyncDemo.saveEmployeesWithLambdaExecutor(new File("employees.json"));
	}

	public Void saveEmployees (File jsonFile) throws InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();
		
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {
			
			@Override
			public void run() {
				try {
					List<Employee> employee = mapper.readValue(jsonFile, new TypeReference<List<Employee>>(){});
					
					//save into database
					
					//employee.stream().forEach(System.out::println);
					System.out.println("Thread :::: " + Thread.currentThread().getName());
					System.out.println("Employee Size :::: " + employee.size());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		return runAsyncFuture.get();
	}
	
	
	public Void saveEmployeesWithLambdaExecutor(File jsonFile) throws InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();
		
		Executor executor = Executors.newFixedThreadPool(5);
		
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
				try {
					List<Employee> employee = mapper.readValue(jsonFile, new TypeReference<List<Employee>>(){});
					
					//save into database
					
					//employee.stream().forEach(System.out::println);
					
					System.out.println("Thread :::: " + Thread.currentThread().getName());
					
					System.out.println("Employee Size :::: " + employee.size());
				} catch (IOException e) {
					e.printStackTrace();
				}
		}, executor);
		
	//	runAsyncFuture.toCompletableFuture();
		return runAsyncFuture.get();
	}

}
