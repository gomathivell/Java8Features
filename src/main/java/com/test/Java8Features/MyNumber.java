package com.test.Java8Features;

import com.test.Java8Features.IF.Calculator;

public class MyNumber {
	
	private long firstNum;
	private long secondNum;
	
	public MyNumber(long firstNum, long secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	
	public long process(Calculator cal) {
		return cal.calculate(this.firstNum, this.secondNum);
	}
	
	public static long diff(long n1, long n2) {
		return n1-n2;
	}
	

	
}
