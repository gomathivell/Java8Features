package com.my.questions.designpattern.decoratordesign;

public class JalepanoDecorator extends PizzaDecorator {

	public JalepanoDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String bake() {
		// TODO Auto-generated method stub
		return pizza.bake() + addJalepano();
	}
	
	public String addJalepano() {
		return "Jalepano";
	}
}
