package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomArrayListTest {
	// Test-driven methodology
	// Step 1 - Write a failing test
	// Step 2 - Write the business logic to make test succeed
	// Step 3 - Refactor your code
	
//	@BeforeEach
	
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
	void add_item_to_front_of_empty_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act stage
		sut.add(0, 100);
		
		// Assert stage
		assertEquals(100, sut.get(0));
		assertEquals(1, sut.getSize());
	}
	
	@Test
	void add_item_to_front_of_list() {
		// Arrange stage
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act stage
		for(int i = 0; i < 2; i++) {
			sut.add(i);
		}
		sut.add(0, 100);
		
		// Assert stage
		assertEquals(100, sut.get(0));
		assertEquals(1, sut.getSize());
	}
	@Test
	void add_item_to_middle_of_list() {
		
	}
	
	@Test
	void add_item_to_end_of_list() {
		
	}
	
	@Test
	void remove_first_item_from_list() {
		
	}

	@Test
	void remove_item_from_middle_of_list() {
				
	}
	
	@Test
	void remove_last_item_from_list() {
		
	}

	
} // end of CustomArrayListTest class
