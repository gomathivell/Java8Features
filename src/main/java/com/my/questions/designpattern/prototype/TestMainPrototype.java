package com.my.questions.designpattern.prototype;

public class TestMainPrototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		VehicleRegistry registry = new VehicleRegistry();
		System.out.println(registry.getVehicle("FOUR").getEngine());
		
		System.out.println(registry.getVehicle("TWO").getEngine());
	}

}
