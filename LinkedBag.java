
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
		// TODO Auto-generated method stub
		
	}

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

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numOfEntries];
		
		int index = 0;
		Node currentNode = head;
		
		while((index < numOfEntries) && (currentNode != null)) {
			result[index] = (T) currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public boolean removeEvery(T anEntry) {
		/**int index = 0;
		Node<T> currentNode = head;
		
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[numOfEntries];
		array = toArray();
		
		while((index < numOfEntries) && (currentNode != null)) {
			if (anEntry == array[index]) {
				remove(anEntry);
			}
			index++;
			currentNode = currentNode.next;
		}
		
		return true;
		*/
		boolean flag = true;
		while (flag) {
			flag = remove(anEntry);
		}
		return flag;
	}
	
	/**
	 * 
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LinkedBag<?>) {
			LinkedBag<T> otherBag = (LinkedBag<T>) obj;
			
			if (this.numOfEntries == otherBag.numOfEntries) {
				
			}
		}
		return false;
	}
	

	
	/**
	 * 
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
