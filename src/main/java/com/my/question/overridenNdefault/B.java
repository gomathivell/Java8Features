package com.my.question.overridenNdefault;

public interface B {

	default void print() {
		System.out.println("Interface B ");
	}
}
