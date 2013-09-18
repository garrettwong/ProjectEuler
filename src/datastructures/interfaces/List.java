package datastructures.interfaces;

public interface List<E> {
	/** Remove all contents from the list, so it is once again 
		empty. Client is responsible for reclaiming storage used 
		by the list elements. */
	public void clear();
	
	/** Insert an element at the current location.  
	 * The client must ensure that the list's capacity is not exceeded. 
	 * @param item The element is to be inserted. */
	public void insert(E item);
	
	public void append(E item);
	
	public E remove();
	
	public void moveToStart();
	
	public void moveToEnd();
	
	public void prev();
	
	public void next();
	
	public int length();
	
	public int currPos();
	
	public void moveToPos(int pos);
	
	public E getValue();
}
