package edu.wmich.CS3310.PA1.JakeKonkowski;
public interface IList<T>{
	// return the pointer to the head node of the list
	INode<T> getHead();
	// set the pointer to the head node of the list
	void setHead(INode<T> head);
	// set the pointer to the tail node of the list
	void setTail(INode<T> tail);
	// return the pointer to the tail node of the list
	INode<T> getTail();
	// return the number of items in the list
	int getSize();
	// set the number of items in the list
	void setSize(int size);
	// return the max number of items the list can hold
	int getCapacity();
	// set the max number of items the list can hold
	void setCapacity(int capacity);
	// return the truth of whether the list is full
	boolean isFull();
	// return the truth of whether the list is empty
	boolean isEmpty();
	// remove item at index i from the list
	T remove(int i);
	// add item x to list at index i
	boolean add(int i, T x);
	
}
