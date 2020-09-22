package edu.wmich.CS3310.PA1.JakeKonkowski;

public class LinkedList<T> implements IList<T> {
	
	private int size;
	private int capacity;
	private INode<T> head;
	private INode<T> tail;

	public LinkedList(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public INode<T> getHead() {
		return head;
	}

	@Override
	public void setHead(INode<T> head) {
		this.head = head;
	}

	@Override
	public void setTail(INode<T> tail) {
		this.tail = tail;
	}

	@Override
	public INode<T> getTail() {
		return tail;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean isFull() {
		return this.size == this.capacity;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public T remove(int i) {
		
		//Negative index failure
		if (i < 0) {
			throw new IndexOutOfBoundsException(String.format("Attempted to remove at index (%d). Index must be positive.", i));
		}
		
		//Index is out of bounds
		if (i > this.getSize()-1) {
			throw new IndexOutOfBoundsException(String.format("Attempted to remove at index (%d) when size is (%d).", i, this.getSize()));
		}
		
		//In the case that i is the head
		if (i == 0) {
			//Sets the node where i=1 to the head and removes the old head as a predecessor. Then returns the data of the old head.
			T data = head.getData();
			
			if (size > 1) {
				Node<T> succ = (Node<T>) head.getSucc();
				succ.setPred(null);
				this.setHead(succ);
			} else { //If the head is the only object in the list
				this.setHead(null);
			}
			
			this.setSize(this.getSize() - 1); //We have to reduce the size manually
			return data;
		}
		
		//In the case that i is the tail
		if (i == this.getSize() - 1) {
			//Sets the node where i=size-2 to the tail and removes the old tail as a successor. Then returns the data of the old tail
			T data = tail.getData();
			Node<T> tempTail = (Node<T>) tail;
			Node<T> pred = (Node<T>) tempTail.getPred();
			pred.setSucc(null);
			this.setTail(pred);
			this.setSize(this.getSize() - 1);
			return data;
		}
		
		//Starts at the beginning of the list
		Node<T> currentNode = (Node<T>) this.getHead();
		T data = null;
		
		for (int x = 0; x <= i; x++) {
			
			//If we are at the index we should be
			if (x == i) {
				Node<T> succ = (Node<T>) currentNode.getSucc(); //Stores the current node's successor
				currentNode.getPred().setSucc(succ); //sets the successor on the predecessor to the successor of the current node.
				succ.setPred(currentNode.getPred()); //sets the predecessor on the successor to the pedecessor of the current node.
				data = currentNode.getData(); //sets data to the current node's data
				this.setSize(this.getSize() - 1);
			} else { //else move on to the next node
				currentNode = (Node<T>) currentNode.getSucc();
			}	
		}
		
		return data;
		
	}

	@Override
	public boolean add(int i, T x) {
		
		//Negative index failure
		if (i < 0) {
			return false;
		}
		
		//Index is out of bounds
		if (i > this.getCapacity() - 1) {
			return false;
		}
		
		//Index is out of bounds
		if (i > this.getCapacity()-1) {
			return false;
		}
		
		if (i == 0) {
			if (this.getSize() == 0) {
				Node<T> newNode = new Node<T>(x);
				this.setHead(newNode);
				this.setSize(1); //Increase the size of the list
				
				return true;
			} else {
				Node<T> newNode = new Node<T>(x);
				Node<T> head = (Node<T>) this.getHead(); //Stores the head node
				head.setPred(newNode);
				newNode.setSucc(head);
				this.setHead(newNode);
				this.setSize(this.getSize() + 1); //Increase the size of the list
				
				return true;
			}
		}
		
		//Starts at the beginning of the list
		Node<T> currentNode = (Node<T>) this.getHead();
		
		for (int k = 0; k < i; k++) {
			
			//If we are at the index before where we're adding
			if (k == i-1) {
				Node<T> newNode = new Node<T>(x);
				Node<T> succ = (Node<T>) currentNode.getSucc(); //Stores the current node's successor
				currentNode.setSucc(newNode); //set's the current node's successor to the new node
				if (succ != null) {
					succ.setPred(newNode); //sets the current node's old successor's predecessor to the new node
				}
				this.setSize(this.getSize() + 1); //Increase the size of the list
				
				return true;
			} else { //else move on to the next node
				currentNode = (Node<T>) currentNode.getSucc();
			}	
		}
		
		return false;
	}

}
