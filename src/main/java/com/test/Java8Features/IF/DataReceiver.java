package com.test.Java8Features.IF;

import java.util.Objects;

public interface DataReceiver<T> extends DataCombiner<T>{
	
	default void receive(TaskHandler task, T t) {
		Objects.requireNonNull(task);
		task.get(combine(t));
	}

}
