package com.my.questions.designpattern.adapterdesignpattern;

public class TestMainDesignPattern {

	public static void main(String[] args) {

		SwiggyStore swiggyStore = new SwiggyStore();
		
		swiggyStore.addItems(new FoodProduct());
		swiggyStore.addItems(new FoodProduct());
		swiggyStore.addItems(new FoodProduct());
		swiggyStore.addItems(new GroceryItemAdapter(new GroceryProduct()));
	}

}
