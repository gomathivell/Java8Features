package com.my.questions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> map = new ConcurrentHashMap();
		
		map.put(1, "one");
		map.put(2, "two");
		
		Iterator<Integer> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			Integer value = it.next();
			System.out.println("Value ::::: " + value);
			map.put(3, "three");
		}
	}

}
