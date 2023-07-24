package com.test.Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.test.Java8Features.IF.SquareFunctionIF;

public class PredicateFunctionalIFTest {

	public static void main(String[] args) {

		Predicate<Integer> lesserThan = i -> i<18;
		System.out.println(lesserThan.test(7));
		
		
		Predicate<Integer> lesserThan1 = i -> i<20;
		Predicate<Integer> greaterThan = i -> i>10;
		
		boolean isTrue = greaterThan.and(lesserThan1).test(15);
		System.out.println(isTrue);
		
		boolean isTruee = greaterThan.and(lesserThan1).negate().test(5);
		System.out.println(isTruee);

		
		
		getPred(5, i -> i>3);
		
		
		//-------------------------------------
		List<Project> proj = new ArrayList<>();
		
		proj.add(new Project("Admin", "Ram"));
		proj.add(new Project("Test", "Ravi"));
		proj.add(new Project("Admin", "Kal"));
		
		
		proj.stream().filter( a -> a.getPname().equalsIgnoreCase("Admin")).forEach( a -> System.out.println(a.getTeamLead()));
		//result.stream().forEach( a -> System.out.println(a.getTeamLead()));
		
		
		
		
		//-----------Function Interface----------------------------
		int a = 5;
		SquareFunctionIF sq = x -> x*x;
		
		int result = sq.calculate(a);
		System.out.println(result);
	}
	
	
	public static void getPred(int i, Predicate<Integer> pre) {
		
		if (pre.test(i)) {
			System.out.println(i);
		}
	}

}
