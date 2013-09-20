package datastructures;

import datastructures.interfaces.TreeNode;

public class BinaryTreeNode<Key, E> implements TreeNode<E> {
	private Key key;						// Key for this node
	private E element; 						// Element for this node
	private BinaryTreeNode<Key, E> left; 	// Pointer to left
	private BinaryTreeNode<Key, E> right; 	// Pointer to right
	
	public BinaryTreeNode() { left = right = null; }
	public BinaryTreeNode(Key k, E val) {
		left = right = null;
		key = k;
		element = val;
	}
	
	public BinaryTreeNode(Key k, E val,
						  BinaryTreeNode<Key, E> l,
						  BinaryTreeNode<Key, E> r) {
		left = l;
		right = r;
		key = k;
		element = val;
	}
	
	public Key key() { return key; }
	public void setKey(Key k) { key = k; }
	
	public E element() { return element; }
	public void setElement(E v) { element = v; }
	
	public BinaryTreeNode<Key, E> left() {
		return left;
	}
	public void setLeft(E v) { element = v; }
	
	public BinaryTreeNode<Key, E> right() {
		return right;
	}
	public void setRight(E v) { element = v; }
	
	
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}
}
