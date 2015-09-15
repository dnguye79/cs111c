/**
 * CS 111C Fall 2015
 * Assignment 3
 * Nguyen, Dao Minh
 */

public class LinkedBag<T> implements LinkedBagInterface<T> {
	private Node<T> head;
	private int numOfEntries;
	
	public LinkedBag() {
		head =  null;
		numOfEntries = 0;
	}
	
	public LinkedBag(T[] a) {
		for (int i = 0; i < a.length; i++) {
			add(a[i]);
		}
	}
	
	@Override
	public int getCurrentSize() {
		return numOfEntries;
	}

	@Override
	public boolean isEmpty() {
		if (numOfEntries > 0) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setData(newEntry);
		//newNode.next = null;
		
		if (numOfEntries == 0) {
			head = newNode;
		} else { // add to end of list
			Node<T> tail = head;
			while (tail.next != null)
				tail = tail.getNextNode();
			tail.next = newNode;
		}
		
		numOfEntries++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove() {
		T result = null;
		if (head != null) {
			result = head.data;
			head = head.getNextNode();
			numOfEntries--;
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		Node<T> nodeN = getReferenceTo(anEntry);
		
		if (nodeN != null) {
			nodeN.data = head.data;
			
			head = head.next;
			numOfEntries--;
			result = true;
		}
		return result;
	}

	@Override
	public void clear() {
		this.head = null;
		numOfEntries = 0;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node<T> currentNode = head;
		
		while((loopCounter < numOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				frequency++;
			}
			loopCounter++;
			currentNode = currentNode.next;
		}
		
		return frequency;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node<T> currentNode = head;
		
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				found = true;
			} else {
				currentNode = currentNode.next;
			}
		}
		
		return found;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[numOfEntries];
		
		int index = 0;
		Node<T> currentNode = head;
		
		while((index < numOfEntries) && (currentNode != null)) {
			result[index] = (T) currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		
		return result;
	}
	
	/**
	 * Remove every instances of the same entry in a bag.
	 * @return true if the operation is successful
	 */
	public boolean removeEvery(T anEntry) {
		boolean flag = true;
		while (flag) {
			flag = remove(anEntry);
		}
		
		if (flag != true)
			return true;
		return false;
	}
	
	/**
	 * Compare the contents of two bags.
	 * @return true when the contents of two bags are the same.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LinkedBag<?>) {
			LinkedBag<T> otherBag = (LinkedBag<T>) obj;
			
			if (this.numOfEntries == otherBag.numOfEntries) {
				Node<T> currNode = head;
							
				for (int i = 0; i < this.numOfEntries; i++) {
					if (otherBag.contains(currNode.data)) {
						if (!(getFrequencyOf(currNode.data) == otherBag.getFrequencyOf(currNode.data)))
							return false;
					} else {
						return false;
					}
					currNode = currNode.next;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Create a union of two bags.
	 * @param other bag to to create union with.
	 * @return bag which contains contents of both bags.
	 */
	public LinkedBag<T> union(LinkedBag<T> other) {
		int numOfEntries = this.numOfEntries + other.numOfEntries;
		
		@SuppressWarnings("unchecked")
		T[] unionArray = (T[]) new Object[numOfEntries];
		
		T[] arrayCurrent = this.toArray();
		T[] arrayOther = other.toArray();
		
		for (int i = 0; i < this.numOfEntries; i++) {
			unionArray[i] = arrayCurrent[i];
		}
		
		for (int i = 0; i < other.numOfEntries; i++) {
			unionArray[this.numOfEntries + i] = arrayOther[i];
		}
		
		LinkedBag<T> unionBag = new LinkedBag<>(unionArray);
		return unionBag;
	}
	
	/**
	 * Locates a given entry within this bag.
	 * @return a reference to the node containing the entry, if located,
	 * or null otherwise.
	 */
	@SuppressWarnings("unchecked")
	private Node<T> getReferenceTo(T anEntry) {
		boolean found = false;
		Node<T> currentNode = head;
		
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				found = true;
			} else {
				currentNode = currentNode.next;
			}
		}
		
		return currentNode;
	}
	
	private class Node<T> {
		private Node next;
		private T data;
		
		public Node(T data, Node nextNode) {
			this.data = data;
			this.next = nextNode;
		}
		
		public Node(T data) {
			this(data, null);
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public Node getNextNode() {
			return next;
		}
		
		public void setNextNode(Node nextNode) {
			this.next = nextNode;
		}
		
	}
}
