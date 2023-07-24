package com.my.questions.designpattern.factorydesignpattern;

public class MainTestFactoryPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OperatingSystem operatingSystem = OperatingSystemFactory.getInstance("WINDOWS", "1.5", "SPORT");

		operatingSystem.changeDir("");
		
		OperatingSystem linuxOperatingSystem = OperatingSystemFactory.getInstance("LINUX", "1.5", "SPORT");

		linuxOperatingSystem.removeDir("");
	}

}
