package com.coderscampus.arraylist;

import java.util.Random;

public class Assignment7App {
	public static final Integer UPPER_BOUND = 1001;

	public static void main(String[] args) {
		CustomList<Integer> numbers = new CustomArrayList<>();
		Random random = new Random(); //generate a range of integers: 0-1000

		/* Load CustomList<Integer>*/
		for (int i = 0; i < 101; i++) {
			numbers.add(random.nextInt(UPPER_BOUND)); //add 100 Integer in the CustomArrayList
		}
		
		System.out.println("Display contents of the Custom List");	
		for (int i = 0; i < numbers.getSize(); i++) {
			System.out.println("numbers["+ i +"] = " + numbers.get(i));
		}
		System.out.println("------------");
		
		System.out.println("Test for index Out of Bounds conditions");
		/* Test for negative index */
//		System.out.println(numbers.get(-1));

		/* Test for Out Of Bounds index */
//		System.out.println(numbers.get(numbers.getSize()+1));
		System.out.println("------------");
		
		CustomList<String> randomStrings = new CustomArrayList<>();
		/* Load CustomList<String>*/
		for (int i = 0; i < 20; i++) {
			randomStrings.add("String-" + random.nextInt(UPPER_BOUND));
		}

		System.out.println("Display contents of the Custom List");	
		for (int i = 0; i < randomStrings.getSize(); i++) {
			System.out.println("randomStrings["+ i +"] = " + randomStrings.get(i));
		}
		System.out.println("------------");

	} //end of main

} //end of Assignment5App class
