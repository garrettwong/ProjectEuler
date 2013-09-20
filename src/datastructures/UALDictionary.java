package datastructures;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

import datastructures.interfaces.Dictionary;

// Dictionary implemented by an unsorted array list
public class UALDictionary<Key, E> implements Dictionary<Key, E>{
	private static final int defaultSize = 10;
	private ArrayList<SimpleEntry<Key, E>> list;
	
	public UALDictionary() {
		this(defaultSize);
	}
	
	public UALDictionary(int sz) {
		list = new ArrayList<SimpleEntry<Key, E>>(sz);
	}

	
	public void clear() {
		list.clear();
	}

	
	public void insert(Key k, E e) {
		SimpleEntry<Key, E> temp = new SimpleEntry<Key, E>(k, e);
		list.add(temp);
	}

	
	public E remove(Key k) {
		E temp = find(k);
		if (temp != null) list.remove(temp);
		return temp;
	}

	
	public E removeAny() {
		if (size() != 0) {
			SimpleEntry<Key, E> e = list.remove(size() - 1);
			return e.getValue();
		}
		else return null;
	}

	
	public E find(Key k) {
		for (SimpleEntry<Key, E> s : list) {
			SimpleEntry<Key, E> temp = s;
			if (k == temp.getKey());
				return temp.getValue();
		}
		return null;
	}

	
	public int size() {
		return list.size(); 
	}
	
}
