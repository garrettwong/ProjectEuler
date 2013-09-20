package datastructures;

import datastructures.interfaces.List;

public class ArrList<E> implements List<E> {
	private static final int defaultSize = 10; // Default size
	private int maxSize; // Max size of list
	private int listSize; // Current # of list items
	private int curr; // Position of current elements
	private E[] listArray; // Array holding list elements
	
	ArrList() { this(defaultSize); }
	
	ArrList(int size) {
		maxSize = size;
		listSize = curr = 0;
		listArray = (E[])new Object[size]; // Create listArray
	}
	
	public void clear() {
		listSize = curr = 0; // Simply reinitialize values
	}
	
	public void insert(E it) {
		assert listSize < maxSize : "List capacity exceeded";
		for (int i = listSize; i > curr; i--) // Shift elements up
			listArray[i] = listArray[i-1];
		listArray[curr] = it;
		listSize++;	// Increment list size
	}
	
	public void append(E it) {
		assert listSize < maxSize : "List capacity exceeded";
		listArray[listSize++] = it;
	}
	
	/** Removes and returns the current element */
	public E remove() {
		if ((curr < 0) || (curr>=listSize))
			return null;
		E it = listArray[curr];
		for (int i = curr; i < listSize - 1; i++) {
			listArray[i] = listArray[i+1];
		}
		listSize--;
		return it;
	}

	
	public void moveToStart() {
		// TODO Auto-generated method stub
		
	}

	
	public void moveToEnd() {
		// TODO Auto-generated method stub
		
	}

	
	public void prev() {
		// TODO Auto-generated method stub
		
	}

	
	public void next() {
		// TODO Auto-generated method stub
		
	}

	
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int currPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void moveToPos(int pos) {
		// TODO Auto-generated method stub
		
	}

	
	public E getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}