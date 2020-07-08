package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import heapsort.HeapSortProcess;
import model.Person;
import util.DefineValues;
import util.ShowProcess;

public class Main {

	private static ArrayList<Person> personList = new ArrayList<>();
	private static ArrayList<Person> sortedpersonList = new ArrayList<>();
	
	public static void main(String[] args) throws ParseException {
		
		
		personList = DefineValues.defineValues(personList);
		
		
		System.out.println("---------------------------------");
		System.out.println("BEFORE HEAP SORT byId");
		ShowProcess.showValues(personList);	
		

		System.out.println("AFTER HEAP SORT byId");
		HeapSortProcess.byId(personList);	
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE HEAP SORT byLastName");		
		ShowProcess.showValues(personList);				
		
		System.out.println("AFTER HEAP SORT byLastName");
		HeapSortProcess.byLastName(personList);	
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE HEAP SORT byName");
		ShowProcess.showValues(personList);

		System.out.println("AFTER HEAP SORT byName");
		HeapSortProcess.byName(personList);
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE HEAP SORT byAge");		
		ShowProcess.showValues(personList);

		System.out.println("AFTER HEAP SORT byAge");
		HeapSortProcess.byAge(personList);
		System.out.println("---------------------------------");
		
		System.out.println("BEFORE HEAP SORT byRegisterDate");		
		ShowProcess.showValues(personList);

		System.out.println("AFTER HEAP SORT byRegisterDate");
		HeapSortProcess.byRegisterDate(personList);
		System.out.println("---------------------------------");
	}
}
