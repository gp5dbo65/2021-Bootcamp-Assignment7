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
	
} //end of CustomArrayList class
