package com.my.questions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Java8CompletableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		Future<List<Integer>>  future = service.submit(() -> {
			//deplay for 1 min
			//blocking main thread
			System.out.println("Here :: " + Thread.currentThread().getName());
		//	delay(1);
			
			return Arrays.asList(1,2,3,4,5);
		});
		
		List<Integer> list = future.get();
		
		
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		completableFuture.get();
		completableFuture.complete("return some dummy data ............... ");
		
		
		
		System.out.println(list);
	}
	
	
	static void runAsynDemo() {
		
	}
	
	private static void delay(int min) {
		try {
			TimeUnit.MINUTES.sleep(min);
		} catch (InterruptedException in) {
			in.printStackTrace();
		}
	}

}
