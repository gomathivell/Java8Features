package com.my.questions.designpattern.decoratordesign;

public class TestMainDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pizza pizza = new JalepanoDecorator(new CheeseBurstDecorator( new BasePizza()));
		
		System.out.println("Pizza :: "+ pizza.bake());
	}

}
