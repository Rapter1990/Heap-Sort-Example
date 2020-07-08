package heapsort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import model.Person;
import util.ShowProcess;

public class HeapSortProcess {
	
	private static ArrayList<Person> sortedpersonList = new ArrayList<>();

	public static void byId(ArrayList<Person> personList) {

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				return Long.compare(p0.getId(), p1.getId());
			}
		};

		
		heapSort(persons, compTr);
		sortedpersonList = new ArrayList<>(Arrays.asList(persons));

		ShowProcess.showValues(sortedpersonList);	
	}

	public static void byLastName(ArrayList<Person> personList) {
		
		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				return collator.compare(p0.getLastname(), p1.getLastname());
			}
		};

		heapSort(persons, compTr);
		sortedpersonList = new ArrayList<>(Arrays.asList(persons));

		ShowProcess.showValues(sortedpersonList);	
	}

	public static void byName(ArrayList<Person> personList) {

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				return collator.compare(p0.getName(), p1.getName());
			}
		};

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		heapSort(persons, compTr);
		sortedpersonList = new ArrayList<>(Arrays.asList(persons));

		ShowProcess.showValues(sortedpersonList);	
	}

	public static void byAge(ArrayList<Person> personList) {

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);
	
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				return Integer.compare(p0.getAge(), p1.getAge());
			}
		};

		heapSort(persons, compTr);
		sortedpersonList = new ArrayList<>(Arrays.asList(persons));

		ShowProcess.showValues(sortedpersonList);	
	}
	
	public static void byRegisterDate(ArrayList<Person> personList) {

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);
	
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				if(p0.getRegisterDate().before(p1.getRegisterDate())){
					return -1;
				}else if(p0.getRegisterDate().after(p1.getRegisterDate())) {
					return 1;
				}else {
					return 0;
				}
			}
		};

		heapSort(persons, compTr);
		sortedpersonList = new ArrayList<>(Arrays.asList(persons));

		ShowProcess.showValues(sortedpersonList);	
	}
	
	
	public static void heapify(Person[] persons, int length, int i , Comparator comp) {
	    int leftChild = 2*i+1;
	    int rightChild = 2*i+2;
	    int largest = i;
	    
	    // if the left child is larger than parent
	    if (leftChild < length && (greaterThan(comp, persons[leftChild], persons[largest]))) {
	        largest = leftChild;
	    }

	    // if the right child is larger than parent
	    if (rightChild < length && (greaterThan(comp, persons[rightChild], persons[largest]))) {
	        largest = rightChild;
	    }   

	    // if a swap needs to occur
	    if (largest != i) {
	    	Person temp = persons[i];
	        persons[i] = persons[largest];
	        persons[largest] = temp;
	        heapify(persons, length, largest, comp);
	    }
	}

	public static Person[] heapSort(Person[] persons, Comparator comp) {

	    // Building the heap
	    int length = persons.length;
	    // we're going from the first non-leaf to the root
	    for (int i = length / 2-1; i >= 0; i--)
	        heapify(persons, length, i, comp);

	    for (int i = length-1; i >= 0; i--) {
	        Person temp = persons[0];
	        persons[0] = persons[i];
	        persons[i] = temp;

	        heapify(persons, i, 0, comp);
	    }
	    
	    return persons;
	}
	
	// ASC
	private static boolean greaterThan(Comparator comp, Person x, Person y) {
		return comp.compare(x, y) > 0;
	}
	
	// DESC
	private static boolean lessThan(Comparator comp, Person x, Person y) {
		return comp.compare(x, y) < 0;
	}

}
