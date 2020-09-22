package edu.wmich.CS3310.PA1.JakeKonkowski;

public class Node<T> implements INode<T> {
	
	//This is basically just a data container.
	
	private T data;
	private INode<T> pred;
	private INode<T> succ;
	
	public Node(T data) {
		this.data = data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public T getData() {
		return data;
	}

	public void setPred(INode<T> pred) {
		this.pred = pred;
	}


	public INode<T> getPred() {
		return pred;
	}

	@Override
	public void setSucc(INode<T> succ) {
		this.succ = succ;
	}

	@Override
	public INode<T> getSucc() {
		return succ;
	}

}
