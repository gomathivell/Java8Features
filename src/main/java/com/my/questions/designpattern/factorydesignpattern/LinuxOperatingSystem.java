package com.my.questions.designpattern.factorydesignpattern;

public class LinuxOperatingSystem extends OperatingSystem {
	
	
	public LinuxOperatingSystem(String version, String architecture) {
		super(version, architecture);
	}

	@Override
	public void changeDir(String dir) {
		System.out.println("Linux's Change dir");
	}

	@Override
	public void removeDir(String dir) {
		System.out.println("Linux remove dir");
	}

}
