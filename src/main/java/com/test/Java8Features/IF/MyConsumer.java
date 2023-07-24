package com.test.Java8Features.IF;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<Integer> {
	

	@Override
	public void accept(Integer t) {
		// TODO Auto-generated method stub
		System.out.println("Output :" + t);
	}

}
