package datastructures.interfaces;

public interface Queue<E> {
	public void clear();
	
	public void enqueue(E it);
	
	public E dequeue();
	
	public E front();
	
	public int length();
}
