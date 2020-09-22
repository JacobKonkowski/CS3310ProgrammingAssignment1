package edu.wmich.CS3310.PA1.JakeKonkowski;
public interface INode<T>{
	// set the data item for the node
	void setData(T data);
	// return the data item reference stored in the node
	T getData();
	// set the pointer to the next linked node to this one
	void setSucc(INode<T> succ);
	// return the pointer to the next linked node to this one
	INode<T> getSucc();
}
