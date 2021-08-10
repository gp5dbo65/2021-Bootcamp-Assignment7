package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	@Override
	public boolean add(T item) {
		if (size == items.length) {
			expandArray();
		}
		items[size] = item; //Add the new item into the array
		size++;	//Increment size index to the next available array entry
		return true;
	} //end of add method

	private void expandArray() {
		Object[] newObjArray = new Object[size*2]; //Double the size of the new array
		for (int i = 0; i < size; i++) { 
			newObjArray[i] = items[i];	//Copy the contents of the old array into the new array			
		} //end for loop
		items = newObjArray; //Reassign items to point to the new array
	}

	@Override
	public int getSize() {
		return size;
	} //end of getSize method

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Custom Array Index out of bounds condition encountered.");
		}
		return (T) items[index];
	} //end of get method

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		// 1) compare index to current array to see if it is out of bounds
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		 
		// 2a) do we need to expand the array? yes, invoke expand method
		if (size == items.length) {
			expandArray();
		}
			
		// 2b) are we at the end? yes, invoke the add method
		if (index == size) {
			return add(item);
		}
		
		// 2c) invoke method to shift arrays elements to the right of index by 1.
		for (int i = size-1; i >= index; i--) {
			items[i+1] = items[i];
		}
		items[index] = item;
		
		// 3) insert item T into index (int) and increment size
		size++;
		
		// 4) return true
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// 1) compare index to current array to see if it is out of bounds
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		
		// 1a) Is the array empty? yes - return null
		if (size == 0) {
			return null;
		}
		
		// 2a) copy contents @ [index] into a temp variable
		T removedItem = (T) items[index];
		
		/* 2b) are we at the end? yes - set the last entry to NULL,
		 * 		 return the contents of temp var */
		// 2c) invoke method to shift array data to the left by 1.
		for (int i = index; i < size-1; i++) {
			items[i] = items[i+1];
		}
		items[size-1] = null; //set the very last item stored in the array to null

		// 3) decrement array size by 1
		size--;
		
		// 4) return item T stored in temp var  
		return removedItem;
	}
	
} //end of CustomArrayList class
