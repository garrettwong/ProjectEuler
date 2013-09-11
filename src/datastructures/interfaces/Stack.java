package datastructures.interfaces;

public interface Stack<E> {
	public void clear();
	
	public void push(E it);
	
	public E pop();
	
	public E top();
	
	public int length();
}
