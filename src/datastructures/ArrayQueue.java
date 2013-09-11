package datastructures;

import datastructures.interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {
	
	private static final int defaultSize = 10;
	private int maxSize;
	private int front;
	private int rear;
	private E[] listArray;
	
	ArrayQueue() { this(defaultSize); }
	ArrayQueue(int size) {
		maxSize = size+1;
		rear = 0; front = 1;
		listArray = (E[]) new Object[maxSize];
	}
	
	@Override
	public void clear() {
		rear = 0; front = 1;
	}

	@Override
	public void enqueue(E it) {
		assert ((rear+2) % maxSize) != front : "Queue is full";
		rear = (rear+1) % maxSize; // Circular
		listArray[rear] = it;
	}

	@Override
	public E dequeue() {
		assert length() != 0 : "Queue is empty";
		E it = listArray[front];
		front = (front+1) % maxSize; // Circular increment
		return it;
	}

	@Override
	public E front() {
		assert length() != 0: "Queue is empty";
		return listArray[front];
	}

	@Override
	public int length() {
		return ((rear+maxSize) - front + 1) % maxSize;
	}
}
