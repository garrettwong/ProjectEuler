package datastructures.interfaces;

public interface BPNode<Key, E> {
	public boolean isLeaf();
	
	public int numrecs();
	
	public Key[] keys();
}
