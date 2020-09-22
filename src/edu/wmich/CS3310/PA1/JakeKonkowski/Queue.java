package edu.wmich.CS3310.PA1.JakeKonkowski;

public class Queue<T> implements IQueue<T> {
	
	//I feel like this is pretty much self documenting.
	
	private IList<T> list;
	private int capacity;
	
	public Queue(int capacity) {
		this.list = new LinkedList<T>(capacity);
	}

	@Override
	public void setFront(INode<T> front) {
		list.setHead(front);
	}

	@Override
	public INode<T> getFront() {
		return list.getHead();
	}

	@Override
	public void setRear(INode<T> rear) {
		list.setTail(rear);
	}

	@Override
	public INode<T> getRear() {
		return list.getTail();
	}

	@Override
	public boolean enqueue(T x) {
		return list.add(list.getSize(), x);
	}

	@Override
	public T dequeue() {
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
	public T poll() {
		if (list.getHead() != null) {
			return list.getHead().getData();
		}
		
		return null;
	}

}
