package com.java.core.convertion;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Arrays;

import sun.security.util.IOUtils;

public class ToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.toString();
		
		Arrays.deepToString(arg0);
		
	}
	
	public void InputStreamToString() {
		FileInputStream inputStream = new FileInputStream("");
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		//org.apache.commons.io.IOUtils
		IOUtils.toString(dataInputStream);
	}

	
	
}
