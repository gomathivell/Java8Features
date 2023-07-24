package com.test.Java8Features;
//https://www.concretepage.com/java/java-8/java-functional-interface
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.test.Java8Features.IF.Calculator;
import com.test.Java8Features.IF.DataCombiner;
import com.test.Java8Features.IF.DataReceiver;
import com.test.Java8Features.IF.ExtraInfoProvider;
import com.test.Java8Features.IF.InfoProvider;
import com.test.Java8Features.IF.MyInterface1;
import com.test.Java8Features.IF.MyInterface2;
import com.test.Java8Features.IF.TaskHandler;
import com.test.Java8Features.IF.Worship;

public class LambdaExperenceTest <T, R> {

	public static void main(String[] args) {

		MyInterface1 myIF1 = (name) -> System.out.println("Name: " + name);
		
		myIF1.method1("Gomathi");
		
		MyInterface2 myIF2 = (name, age) -> { System.out.println( "Name ::" + name  + " Age : " + age);
											  System.out.println( "Name 2 ::" + name  + " Age 2: " + age); };
		
		myIF2.method2("Testing", 9);
		
		
		
		List<MyNumber> list = new ArrayList<>();
		list.add(new MyNumber(3, 6));
		list.add(new MyNumber(3, 7));
		list.add(new MyNumber(3, 8));
		list.add(new MyNumber(3, 9));
		list.add(new MyNumber(3, 4));
		
		
		Calculator cal = (n1,n2) -> n1+n2;
		
		for ( MyNumber m : list) {
			System.out.println(m.process(cal)); // send interface.
			System.out.println(m.process((n1,n2) -> n1+n2));	// send the lambada expression
		}
		
		MyNumber m1 = new MyNumber(7, 5);
		Calculator calStatic = MyNumber :: diff;  // static method reference
		
		System.out.println("Diff : " + calStatic.calculate(30, 12));
		System.out.println(" Method Ref :" + m1.process(MyNumber :: diff));
		

		//-----------------------------------------------------
		
		Worship worship = (name) -> System.out.println(name);
		
		worship.again(worship).again(worship).chant("Ram");
		
		
		//-------------------------------------------------
		// String combine(T t);
		
		DataCombiner<Project> dataCombiner = (Project p) -> {
			if (p.getLocation() == null) {
				return p.getPname() + " : " + p.getTeamLead();
			} else {
				return p.getPname() + " : " + p.getTeamLead() + " : " + p.getLocation();
			}
		};
		
		
		InfoProvider<Employee, Project> infoProvide = (Employee emp) -> {
			if(emp.getId() > 100) {
				return new Project("ABCD", emp.getName());
			} else {
				return new Project("PQRS", emp.getName());
			}
		};
		
		 ExtraInfoProvider<Project> extraInfoProvider = (Project p) -> {
	        	p.setLocation("Noida");
	        	return p;
	        };    

		InfoProvider<Employee, Project> s = infoProvide.addMore(extraInfoProvider);
				
				//.addCombiner(dataCombiner).combine(new Employee("Mahesh", 50));
		
		System.out.println(s.toString());
		
		
		DataReceiver<Employee> combine = (Employee emp) -> emp.getId() + "-" + emp.getName();
		
		TaskHandler tskHandler = (res) -> System.out.println(res);
		
		combine.receive(tskHandler, new Employee(1,"TestName", 7));
		
		combine.combine(new Employee(3, "TestName", 7));
		
		List numbers = Arrays.asList(4,5,7,9);
		
		Function<Integer, Integer> f = Integer::new;
		
		List sqNum = LambdaExperenceTest.findSquareRoot(numbers, f); 
		System.out.println("Square root of numbers = "+sqNum);
		
	}

	private static List findSquareRoot(List list, Function<Integer, Integer> f) {
		List result = new ArrayList();
		
		
		
		list.forEach(a -> result.add(Math.sqrt(f.apply((Integer)a))));
		
		//This also possible
		
		list.forEach(a -> result.add(Math.sqrt((Integer)a)));
		return result;
	}

	
	
	
	
}
