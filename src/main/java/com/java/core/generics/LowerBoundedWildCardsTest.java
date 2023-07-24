package com.java.core.generics;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildCardsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Object> objList = new ArrayList<>();
		
		addNumber(objList);
		
		List<Integer> intList = new ArrayList<>();
		intList.add(12);
		intList.add(13);
		addNumber(intList);
		
		
		//-----------------------------------------------------------------
		//this works but passing this to 
		List<Animal> ani = new ArrayList<>();
		ani.add(new Dog());
		ani.add(new Dog());
		

	}
	
	public static void addNumber(List<? super Integer> list) {
		for(int i=0; i<=10; i++) {
			list.add(i);
		}
		System.out.println(list.toString());
	}
	

	//-----------------------------------------------------------------------
	
	
	public void addAnimal(List<? extends Animal> animals) {
		animals.add(new Animal()); // NO! Can't add if we
		// use <? extends Animal>
		
		//we can add only, if <? super Animal>
	}
}
