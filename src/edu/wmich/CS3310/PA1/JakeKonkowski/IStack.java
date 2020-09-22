package edu.wmich.CS3310.PA1.JakeKonkowski;
public interface IStack<T>{
	// set the pointer to the top node of the stack
	void setTop(INode<T> top);
	// return the pointer to the head node of the list
	INode<T> getTop();
	// add new item x to the top of the stack
	boolean push(T x);
	// remove an item from the top of the stack
	T pop();
	// set the pointer to the list used as the stack
	void setList(IList<T> list);
	// return the pointer to the list used as the stack
	IList<T> getList();
	// clear all items from the stack
	void clear();
	// looks at the item at the top of the stack without removal
	T peek();

}
