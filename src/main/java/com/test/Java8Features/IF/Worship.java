package com.test.Java8Features.IF;

@FunctionalInterface
public interface Worship {

	public void chant(String name);
	
	default Worship again (Worship w) {
		
		return (name) -> {
				chant(name);
				w.chant(name);
			};
		}
	/*
	default Worship get (String name, Worship w) {
		chant(name);
		return w.chant(name);
	}*/
}
