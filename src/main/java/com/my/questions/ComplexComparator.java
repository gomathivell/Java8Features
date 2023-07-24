package com.my.questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexComparator {

	//Compare by firstName and lastName
	public static void main(String[] args) {
		
		 ArrayList<EmployeeNames> employees = getUnsortedEmployeeList();
		 
		 Comparator<EmployeeNames> compareByName = Comparator.comparing(EmployeeNames::getFirstName)
				 									.thenComparing(EmployeeNames::getLastName);
		 
		 List<EmployeeNames> employeeList = employees.stream().sorted(compareByName).collect(Collectors.toList());
		 
		 System.out.println(employeeList);
	}

	
	private static ArrayList<EmployeeNames> getUnsortedEmployeeList() 
	  {
	    ArrayList<EmployeeNames> list = new ArrayList<>();
	    list.add( new EmployeeNames(2, "Lokesh", "Gupta") );
	    list.add( new EmployeeNames(1, "Alex", "Gussin") );
	    list.add( new EmployeeNames(4, "Brian", "Sux") );
	    list.add( new EmployeeNames(5, "Neon", "Piper") );
	    list.add( new EmployeeNames(3, "David", "Beckham") );
	    list.add( new EmployeeNames(7, "Alex", "Beckham") );
	    list.add( new EmployeeNames(6, "Brian", "Suxena") );
	        return list;
	  }
}
