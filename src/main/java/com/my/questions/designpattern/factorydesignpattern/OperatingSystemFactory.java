package com.my.questions.designpattern.factorydesignpattern;

public class OperatingSystemFactory {
	
	
	public static OperatingSystem getInstance(String type, String version, String architecture) {
		
		switch(type) {
		
			case "WINDOWS":
				return new WindowOperationSystem(version, architecture);
			case "LINUX":
				return new LinuxOperatingSystem(version, architecture);
			default:
					throw new IllegalArgumentException("OS Not supported");
		}
	}
}
