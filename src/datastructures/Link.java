package datastructures;

public class Link<E> {
	private E element;
	private Link<E> next;
	
	Link(E it, Link<E> nextVal) {
		element = it; next = nextVal;
	}
	
	Link(Link<E> nextVal) { next = nextVal; };
	
	Link<E> next() { return next; }
	Link<E> setNext(Link<E> nextVal) { return next = nextVal; }
	E element() { return element; }
	E setElement(E it) { return element = it; }
	
	static Link freelist = null;
	static<E> Link<E> get(E it, Link<E> nextVal) {
		if (freelist == null) {
			return new Link<E>(it, nextVal);
		}
		Link<E> temp = freelist;
		freelist = freelist.next();
		temp.setElement(it);
		temp.setNext(nextVal);
		return temp;
	}
	
	void release() {
		element = null;
		next = freelist;
		freelist = this;
	}
}
