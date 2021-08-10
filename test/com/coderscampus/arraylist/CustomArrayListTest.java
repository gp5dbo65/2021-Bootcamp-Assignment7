package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomArrayListTest {
	// Test-driven methodology
	// Step 1 - Write a failing test
	// Step 2 - Write the business logic to make test succeed
	// Step 3 - Refactor your code
	

	@Test
	void should_add_one_item_to_list() {
		// Three A's
		// Arrange, Act, Assert
		
		// Arrange stage
		// sut - system under test
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act stage
		sut.add(10);
		Integer expectedResult = sut.get(0);
		Integer expectedSize = sut.getSize();
		
		// Assert stage
		// What would we expect to happen?
		// I expect there to be an Integer with a value of 10 stored in
		// the first index in the customIntegerList
		assertEquals(10, expectedResult);
		assertEquals(1, expectedSize);
	} // end of should_add_one_item_to_list method

	@Test
	void should_add_11_items_to_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act stage
		for(int i  = 0; i < 11; i++) {
			sut.add(i);			
		} //end for loop
		
		// Assert stage
		for(int i = 0; i < 11; i++) {
			assertEquals(i, sut.get(i));
		} //end for loop
		assertEquals(11, sut.getSize());		
	} // end of should_add_11_itmes_to_list method
	
	@Test
	void should_cause_out_of_bounds_error() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act stage
//		sut.add(-5,100); //check - Exception thrown
//		sut.add(1,100);	 //check - Exception thrown
//		sut.add(10,100); //check - Exception thrown
		sut.remove(0);
//		sut.remove(5);	 //check - Exception thrown
//		sut.remove(9);	 //check - Exception thrown
		
		// Assert stage
		assertEquals(null, sut.remove(0));
	} //end of should_cause_out_of_bounds_error
	
	@Test
	void should_add_item_to_front_of_empty_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		assertEquals(null, sut.get(0));
		assertEquals(0, sut.getSize());
		
		// Act stage
		sut.add(0, 100);
		
		// Assert stage
		assertEquals(100, sut.get(0));
		assertEquals(null, sut.get(1));
		assertEquals(1, sut.getSize());		
	} //end of should_add_item_to_front_of_empty_list
	
	@Test
	void should_add_item_to_front_of_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		for(int i = 0; i < 11; i++) {
			sut.add(i);
		}
		assertEquals(0, sut.get(0));
		assertEquals(1, sut.get(1));
		assertEquals(2, sut.get(2));
		assertEquals(3, sut.get(3));
		assertEquals(4, sut.get(4));
		assertEquals(5, sut.get(5));
		assertEquals(6, sut.get(6));
		assertEquals(7, sut.get(7));
		assertEquals(8, sut.get(8));
		assertEquals(9, sut.get(9));
		assertEquals(10, sut.get(10));
		assertEquals(null, sut.get(11));
		assertEquals(11, sut.getSize());
		
		// Act stage
		sut.add(0, 100);
		
		// Assert stage
		assertEquals(100, sut.get(0));
		assertEquals(0, sut.get(1));
		assertEquals(1, sut.get(2));
		assertEquals(2, sut.get(3));
		assertEquals(3, sut.get(4));
		assertEquals(4, sut.get(5));
		assertEquals(5, sut.get(6));
		assertEquals(6, sut.get(7));
		assertEquals(7, sut.get(8));
		assertEquals(8, sut.get(9));
		assertEquals(9, sut.get(10));
		assertEquals(10, sut.get(11));
		assertEquals(null, sut.get(12));
		assertEquals(12, sut.getSize());
	} //end of should_add_item_to_front_of_list
	
	@Test
	void should_add_item_to_middle_of_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		for(int i = 0; i < 11; i++) {
			sut.add(i);
		}
		
		// Act stage
		sut.add(7, 100);
		
		// Assert stage
		assertEquals(6, sut.get(6));
		assertEquals(100, sut.get(7));
		assertEquals(7, sut.get(8));
		assertEquals(8, sut.get(9));
		assertEquals(9, sut.get(10));
		assertEquals(10, sut.get(11));
		assertEquals(null, sut.get(12));
		assertEquals(12, sut.getSize());
	} //end of should_add_item_to_middle_of_list
	
	@Test
	void should_add_item_to_end_of_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		for(int i = 0; i < 10; i++) {
			sut.add(i);
		}
		
		// Act stage
		sut.add(10, 100);
		
		// Assert stage
		assertEquals(9, sut.get(9));
		assertEquals(100, sut.get(10));
		assertEquals(null, sut.get(11));
		assertEquals(11, sut.getSize());
	} //end of should_add_item_to_end_of_list
	
	@Test
	void should_add_items_to_large_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		for(int i = 0; i < 5000; i++) {
			sut.add(i);
		}
		assertEquals(4999, sut.get(4999));
		assertEquals(null, sut.get(5000));
		assertEquals(5000, sut.getSize());
		
		// Act stage
		sut.add(0, -9999);		//add to front of list
		sut.add(2500, 5555);	//add to middle of list
		sut.add(5002, 9999);	//add to end of list
		
		// Assert stage
		assertEquals(-9999, sut.get(0)); //value expected at front of list
		assertEquals(0, sut.get(1));	 //value expected at index 1
		assertEquals(2498, sut.get(2499));
		assertEquals(5555, sut.get(2500));	//value expected at middle of list
		assertEquals(2499, sut.get(2501));
		assertEquals(4999, sut.get(5001));
		assertEquals(9999, sut.get(5002));	//value expected at last entry of list
		assertEquals(null, sut.get(5003));
		assertEquals(5003, sut.getSize());
		
	} //end of should_add_item_to_middle_of_large_list
	
	@Test
	void should_remove_item_from_empty_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act stage
		Integer removedItem = sut.remove(0);
		
		// Assert stage
		assertEquals(null, removedItem);
		assertEquals(0, sut.getSize());
	} //end of should_remove_item_from_empty_list
	
	@Test
	void should_remove_first_item_from_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 0; i < 10; i++) {
			sut.add(i, i*10);
		}
		assertEquals(0, sut.get(0));
		assertEquals(90, sut.get(9));
		assertEquals(10, sut.getSize());
		
		// Act stage
		Integer removedItem = sut.remove(0);
		
		// Assert stage
		assertEquals(0, removedItem);
		assertEquals(10, sut.get(0));
		assertEquals(90, sut.get(8));
		assertEquals(null, sut.get(9));
		assertEquals(9, sut.getSize());
	} //end of should_remove_first_item_from_list

	@Test
	void should_remove_item_from_middle_of_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 0; i < 10; i++) {
			sut.add(i, i*10);
		}
		
		// Act stage
		Integer removedItem = sut.remove(5);
		
		// Assert stage
		assertEquals(50, removedItem);
		assertEquals(40, sut.get(4));
		assertEquals(60, sut.get(5));
		assertEquals(90, sut.get(8));
		assertEquals(null, sut.get(9));
		assertEquals(9, sut.getSize());
	} //end of should_remove_item_from_middle_of_list
	
	@Test
	void should_remove_last_item_from_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 0; i < 10; i++) {
			sut.add(i, i*10);
		}
		
		// Act stage
		Integer removedItem = sut.remove(9);
		
		// Assert stage
		assertEquals(90, removedItem);
		assertEquals(80, sut.get(8));
		assertEquals(null, sut.get(9));
		assertEquals(9, sut.getSize());
	} //end of should_remove_last_item_from_list

	
} // end of CustomArrayListTest class
