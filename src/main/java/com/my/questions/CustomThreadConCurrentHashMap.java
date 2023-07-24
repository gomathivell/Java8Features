package com.my.questions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomThreadConCurrentHashMap extends Thread {
	
	static Map<Integer, String> map = new ConcurrentHashMap<Integer, String>();
	
	 @Override
	public void run() {
		try {
			Thread.sleep(1000);
			
			map.put(105, "Five");
			
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) throws InterruptedException {

		map.put(100, "A");
		map.put(101, "B");
		map.put(102, "C");
		
		CustomThreadConCurrentHashMap currentHashMap = new CustomThreadConCurrentHashMap();
		
		currentHashMap.start();
		
		for (Object o: map.entrySet()) {
			Object s = o;
			System.out.println("Output :" + s );
			Thread.sleep(1000);
		}
		System.out.println(map);
	}

}
