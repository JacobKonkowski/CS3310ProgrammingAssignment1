package edu.wmich.CS3310.PA1.JakeKonkowski;

public class Stack<T> implements IStack<T> {
	
	//I feel like this is pretty much self documenting.
	
	private IList<T> list;
	private int capacity;
	
	public Stack(int capacity) {
		this.list = new LinkedList<T>(capacity);
		this.capacity = capacity;
	}

	@Override
	public void setTop(INode<T> top) {
		list.setHead(top);
	}

	@Override
	public INode<T> getTop() {
		return list.getHead();
	}

	@Override
	public boolean push(T x) {
		return list.add(0, x);
	}

	@Override
	public T pop() {
		return list.remove(0);
	}

	@Override
	public void setList(IList<T> list) {
		this.list = list;
	}

	@Override
	public IList<T> getList() {
		return list;
	}

	@Override
	public void clear() {
		this.list = new LinkedList<T>(capacity);
	}

	@Override
	public T peek() {
		if (list.getHead() != null) {
			return list.getHead().getData();
		}
		
		return null;
	}
}
