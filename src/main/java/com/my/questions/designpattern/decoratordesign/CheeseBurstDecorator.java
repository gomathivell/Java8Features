package com.my.questions.designpattern.decoratordesign;

public class CheeseBurstDecorator extends PizzaDecorator {

	public CheeseBurstDecorator(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public String bake() {
		// TODO Auto-generated method stub
		return pizza.bake() + addCheeseBurst();
	}
	
	public String addCheeseBurst() {
		return "extra cheese";
	}

}
