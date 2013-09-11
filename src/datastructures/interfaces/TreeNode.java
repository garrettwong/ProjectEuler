package datastructures.interfaces;

public interface TreeNode<E> {
	public E element();
	public void setElement(E v);
	
	public TreeNode<E> left();
	public TreeNode<E> right();
	
	public boolean isLeaf();
}
