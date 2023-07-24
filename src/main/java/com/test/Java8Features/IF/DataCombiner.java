package com.test.Java8Features.IF;

@FunctionalInterface
public interface DataCombiner<T> {
  String combine(T t);
}
