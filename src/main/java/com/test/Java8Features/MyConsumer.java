package com.test.Java8Features;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<Integer>{

	public void accept(Integer it) {
		System.out.println("Output From Class : " + it);
	}

}
