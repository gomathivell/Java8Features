package com.java.core.generics;

import java.io.Serializable;

//T - type , Type will be passed by calling method
//we can set the boundaries for Object type <T extends Number>
public class Counter<T extends Number & Serializable> {
	
	T i;
	
	public Counter(T i) {
		this.i = i;
	}
	
	public void print() {
		System.out.println(i);
	}
}
