package com.my.questions.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
	private static Map<String, Vehicle> mapVehicle = new HashMap<>();
	static {
		mapVehicle.put("TWO", new TwoWheelerVehicle("120", "camry", 2500, false));
		mapVehicle.put("FOUR", new FourWheelerVehicle("350", "Toyato", 25000, true, false));
	}
	
	public Vehicle getVehicle(String type) throws CloneNotSupportedException {
		return mapVehicle.get(type).clone();
	}
}
