package com.my.questions.designpattern.adapterdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class SwiggyStore {
	List<FoodItem> itemDetails = new ArrayList<>();
	
	public void addItems(FoodItem item) {
		itemDetails.add(item);
	}

}
