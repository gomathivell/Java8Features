package com.my.questions.designpattern.decoratordesign;

public abstract class PizzaDecorator implements Pizza {
	
	protected Pizza pizza;

	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String bake() {
		// TODO Auto-generated method stub
		return pizza.bake();
	}
	

}
