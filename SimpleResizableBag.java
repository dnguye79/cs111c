public class SimpleResizableBag<T> implements Resizable {
	private T[] bag;
	private int numOfEntries;

	public SimpleResizableBag(int capacity) {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[capacity];
		bag = tempBag;
		numOfEntries = 0;
	}

	
	public int getCapacity() {
		return bag.length;
	}

	
	public void doubleCapacity() {
		@SuppressWarnings("unchecked")
		T[] tempDoubleCapacityBag = (T[]) new Object[this.bag.length * 2];
		T[] doubleCapacityBag = tempDoubleCapacityBag;

		for (int i = 0; i < numOfEntries; i++) 
			doubleCapacityBag[i] = this.bag[i];

		bag = doubleCapacityBag;
	}
}