package com.my.questions;
//write encoder program
public class TestEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String getValue(Integer inputValue) {
		String result = null;
		if(inputValue != 0 && inputValue != null) {
			String intToStr = inputValue.toString();	
			
			if(intToStr != null) {
				int strLength = intToStr.length();
				
				if (strLength >= 2 ) 
				{
					
				} else {
					String[] st1 = intToStr.split(intToStr, 1);
					 String v1 = st1[0];
					
					
				}
			}
			
			
		}
		
		
		
		return result;
	}

}
