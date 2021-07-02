package com.coderscampus.arraylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

		speedTest();

	} //end of main

	public static void speedTest() {
		Date startTime = new Date();
		
		List<Integer> arrayListNumbers = new ArrayList<>();
		
		for (int i = 0; i < 100000000; i++) {
			arrayListNumbers.add(i);
		}
		
		Date endTime = new Date();
		System.out.println("ARRAYLIST: The time it took to add numbers is: "
			+ (endTime.getTime() - startTime.getTime()) + " milliseconds");
		
		Date startTimeCustomList = new Date();
		
		CustomList<Integer> customListNumbers = new CustomArrayList<>();
		
		for (int i = 0; i < 100000000; i++) {
			customListNumbers.add(i);
		}
		
		Date endTimeCustomList = new Date();
		System.out.println("CUSTOM ARRAY LIST: The time it took to add numbers is: "
			+ (endTimeCustomList.getTime() - startTimeCustomList.getTime()) + " milliseconds");
		
	} //end of speedTest method

} //end of Assignment5App class
