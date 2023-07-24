package com.my.questions;

import java.util.Arrays;
import java.util.Optional;

import com.java.core.Customer;

public class OptionalDemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer = new Customer(101, "Goms", "mail@gmail.com", Arrays.asList("5643.78","74564.546"));
		
		//empty
		//of  - throws Nullpointer
		//ofNullable
		
		//orElse
		//orElseGet
		//orElseThrow
		
		Optional<Object> emptyOptional = Optional.empty();
		
		System.out.println(emptyOptional);
		
/*		Optional<String> emptEmail = Optional.of(customer.getEmail());
		System.out.println(emptEmail);
*/		
		
		Optional<String> emptEmailNullable = Optional.ofNullable(customer.getEmail());
		System.out.println(emptEmailNullable);
		
		
		Optional<String> name = Optional.ofNullable(customer.getName());
		
		if (name.isPresent()) {
			System.out.println(name.get());
		}
		
		//Optional orElse
		Optional<String> emptEmailNullableElse = Optional.ofNullable(customer.getEmail());
		System.out.println(emptEmailNullable);
		
		System.out.println(emptEmailNullableElse.orElse("defualt@gmail.com"));
		System.out.println(emptEmailNullableElse.orElseThrow( () -> new IllegalArgumentException("Exception *****")));
		
		//orElseGet - takes supplier
		System.out.println(emptEmailNullableElse.map(String::toUpperCase).orElseGet(() ->"defualt@gmail.com"));
		
		
	}

}
