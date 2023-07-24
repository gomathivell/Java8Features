package com.test.Java8Features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java8ForEachExample {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			myList.add(i);
		}
		
		/*Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			System.out.println("Value : " + integer);
		}
		
		myList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("Output ::" +t);
			}
		});
		
		MyConsumer myConsumer = new MyConsumer();
		myList.forEach(myConsumer);
				
		myList.forEach(System.out::println);
		*/
		
		List<String> items = new ArrayList<String>();
		
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");
		
	//	items.forEach(System.out::println);
		
	//	items.forEach(item -> System.out.println(item));
		
		items.forEach(item -> {
			if("C".equalsIgnoreCase(item)) {
				System.out.println(item);
			}
		});
		
		items.stream()
			 .filter(s -> s.contains("B"))
			 .forEach(System.out::println);
		
		
		Map<String, Integer> itemsMap = new HashMap();
		
		itemsMap.put("A", 10);
		itemsMap.put("B", 20);
		itemsMap.put("C", 30);
		itemsMap.put("D", 40);
		itemsMap.put("E", 50);
		
		itemsMap.forEach((k,v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)) {
				System.out.println("Hello E");
			}
		});
		
		
	}

	
	public void getListOfValues() {
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");
		
	//	items.forEach(arg0);
	}
	
}
