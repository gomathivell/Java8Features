package com.java.core.convertion;

import java.io.File;

public class FileAndAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File("employee.json");
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		

	}

}
