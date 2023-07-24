package com.test.Java8Features.IF;

import java.util.Objects;

public interface InfoProvider<T, R> {
	
	R provide(T t);
	
	default InfoProvider<T, R> addMore(ExtraInfoProvider<R> more) {
		return (T t) -> {
			Objects.requireNonNull(t);
			R r = provide(t);
			return more.provider(r);
		};
	}

	default DataCombiner<T> addCombiner(DataCombiner<R> combiner) {
		return (T t) -> {
			Objects.requireNonNull(combiner);
			return combiner.combine(provide(t));
		};
		
	}
}
