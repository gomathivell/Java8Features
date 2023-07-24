package com.my.questions.designpattern.factorydesignpattern;

public class WindowOperationSystem extends OperatingSystem {

	public WindowOperationSystem(String version, String architecture) {
		super(version, architecture);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void changeDir(String dir) {
		// TODO Auto-generated method stub
		System.out.println("Windows's Change dir");
	}

	@Override
	public void removeDir(String dir) {
		// TODO Auto-generated method stub
		System.out.println("Windows's remove dir");
	}

}
