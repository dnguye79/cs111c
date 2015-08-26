//08262015
public class ArrayBag<T> implements BagInterface<T> {
	//private String[] bag;
	//private T[] bag;
	private final T[] bag;
	private int numOfEntries;
	//...
	public ArrayBag(int capacity) {
		//bag = new T[capacity]; cannot initialize array of generics
		// bag = new Object[capacity]; type mismatch
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[capacity];
		// bag = (T[]) new Object[capacity];
		bag = tempBag;
		numOfEntries = 0;
	}
	@Override
	public int getCurrentSize() {
		/**int size = 0;
		for (int i = 0; i < bag.length; i++) {
			if (bag[i] != null)
				size++;
		}
		
		return size;*/
		return numOfEntries;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
