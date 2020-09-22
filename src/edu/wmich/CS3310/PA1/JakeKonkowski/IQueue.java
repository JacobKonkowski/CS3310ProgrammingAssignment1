package edu.wmich.CS3310.PA1.JakeKonkowski;
public interface IQueue<T>{
	// set the pointer to the front node of the queue
	void setFront(INode<T> front);
	// return the pointer to the front node of the queue
	INode<T> getFront();
	// set the pointer to the rear node of the queue
	void setRear(INode<T> rear);
	// return the pointer to the rear node of the queue
	INode<T> getRear();
	// add new item x to the front of the queue
	boolean enqueue(T x);
	// remove an item from the rear of the queue
	T dequeue();
	// set the pointer to the list used as the queue
	void setList(IList<T> list);
	// return the pointer to the list used as the stack
	IList<T> getList();
	// clear all items from the queue
	void clear();
	// looks at the item at the rear of the queue without removal
	T poll();
}