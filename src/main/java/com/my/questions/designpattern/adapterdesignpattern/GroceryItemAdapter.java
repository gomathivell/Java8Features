package com.my.questions.designpattern.adapterdesignpattern;

public class GroceryItemAdapter implements FoodItem {
	
	GroceryItem item;
	
	public GroceryItemAdapter(GroceryItem item) {
		super();
		this.item = item;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return item.getItemName();
	}

	@Override
	public String getPrice() {
		// TODO Auto-generated method stub
		return item.getPrice();
	}

	@Override
	public String getRestaurantName() {
		// TODO Auto-generated method stub
		return item.getStoreName();
	}

}
