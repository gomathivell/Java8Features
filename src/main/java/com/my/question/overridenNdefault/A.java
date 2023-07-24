package com.my.question.overridenNdefault;

public interface A {

	default void print() {
		System.out.println("Interface A ");
	}
}
