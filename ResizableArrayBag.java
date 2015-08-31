
/**
 * CS 111C Fall 2015
 * Assignment 2
 * Nguyen, Dao Minh
 */

import java.util.Arrays;
import java.util.ArrayList;

public class ResizableArrayBag<T> implements BagInterface<T> {
	private T[] bag; // Cannot be final due to doubling
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ResizableArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/** Creates an empty bag having a given initial capacity.
	    @param initialCapacity  The integer capacity desired. */
	public ResizableArrayBag(int initialCapacity) {
		checkCapacity(initialCapacity);
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[initialCapacity]; // Unchecked cast
		bag = tempBag;
		numberOfEntries = 0;
		initialized = true;
	} // end constructor

	/** Creates a bag containing given entries.
	 * @param contents  An array of objects. */
	public ResizableArrayBag(T[] contents) {
		checkCapacity(contents.length);
		bag = Arrays.copyOf(contents, contents.length);
		numberOfEntries = contents.length;
		initialized = true;
	} // end constructor
       
	/** Adds a new entry to this bag.
	 * @param newEntry  The object to be added as a new entry.
	 * @return  True. */
	public boolean add(T newEntry) {
		checkInitialization();
		if (isArrayFull()) {
			doubleCapacity();
		} // end if

		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		
		return true;
	} // end add
	
	/** Retrieves all entries that are in this bag.
	 * @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray() {
		checkInitialization();
		
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		} // end for
		
		return result;
	} // end toArray
	
	/** Sees whether this bag is empty.
       @return  True if this bag is empty, or false if not. */
	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the current number of entries in this bag.
       @return  The integer number of entries currently in this bag. */
	public int getCurrentSize()
	{
      return numberOfEntries;
	} // end getCurrentSize
   
	/** Counts the number of times a given entry appears in this bag.
       @param anEntry  The entry to be counted.
       @return  The number of times anEntry appears in this ba. */
	public int getFrequencyOf(T anEntry)
	{
		checkInitialization();
      int counter = 0;
      
      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(bag[index]))
         {
            counter++;
         } // end if
      } // end for
      
      return counter;
	} // end getFrequencyOf
   
	/** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if this bag contains anEntry, or false otherwise. */
	public boolean contains(T anEntry) {
		checkInitialization();
		return getIndexOf(anEntry) > -1; // or >= 0
	} // end contains
   
	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear
	
	/** Removes one unspecified entry from this bag, if possible.
	 * @return  Either the removed entry, if the removal
	 * was successful, or null. */
	public T remove() {
		checkInitialization();
		T result = removeEntry(numberOfEntries - 1);
		
		if (isTooBig())
			reduceArray();
		
		return result;
	} // end remove
	
	/** Removes one occurrence of a given entry from this bag.
	 * @param anEntry  The entry to be removed.
	 * @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry) {
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		
		if (isTooBig())
			reduceArray();
		
		return anEntry.equals(result);
	} // end remove
	
	@Override
	public ResizableArrayBag<T> union(ResizableArrayBag<T> other) {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[this.numberOfEntries + other.numberOfEntries];
		for (int i = 0; i < this.numberOfEntries; i++) {
			tempBag[i] = bag[i];
		}
		for (int i = 0; i < other.numberOfEntries; i++) {
			tempBag[this.numberOfEntries + i] = other.bag[i];
		}
		
		ResizableArrayBag<T> unionBag = new ResizableArrayBag<T>(tempBag);
		return unionBag;
	}
	
	@Override
	public ResizableArrayBag<T> intersection(ResizableArrayBag<T> other) {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[this.numberOfEntries + other.numberOfEntries];
		ArrayList<Integer> occur = new ArrayList<Integer>();
		ArrayList<T> value = new ArrayList<T>();
		ArrayList<Integer> skip = new ArrayList<Integer>();
		boolean flagb = false;
		
		for (int i = 0; i < this.numberOfEntries; i++) {
			if (flagb) {
				if (skip.get(i-1) == i)
					continue;
			}
			
			int counterT = 0, counterO = 0;
				
			for (int ix = 0; ix < this.numberOfEntries; ix++) {
				if (this.bag[i] == this.bag[ix]) {
					counterT++;
					
					skip.add(ix);
				}
			}
			flagb = true;
			
			
			boolean flag = true;
			for (int y = 0; y < other.numberOfEntries; y++) {
				if (this.bag[i].equals(other.bag[y])) {
					counterO++;
					if(flag) {
						value.add(other.bag[y]);
						flag = false;
					}
				}
			}
			
			if (counterT < counterO)
				occur.add(counterT);
			else
				occur.add(counterO);
		}
		
		int counter = 0;
		for (int x = 0; x < value.size(); x++) {
			for (int y = 0; y < occur.size(); y++) {
				for (int z = 0; z < occur.get(y); z++) {
					System.out.println(occur.get(y));
					tempBag[counter] = value.get(x);
					
				}
				
			}
		}
	
		
		ResizableArrayBag<T> intersectBag = new ResizableArrayBag<T>(tempBag);
		return intersectBag;
	}
	
	@Override
	public ResizableArrayBag<T> difference(ResizableArrayBag<T> other) {
		return null;
	}
	
	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located,
	// or -1 otherwise.
	// Precondition: checkInitialization has been called.
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;
		
		while (!found && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
				where = index;
			} // end if
			index++;
		} // end while
		
		// Assertion: If where > -1, anEntry is in the array bag, and it
		// equals bag[where]; otherwise, anEntry is not in the array.
		return where;
	} // end getIndexOf
   
   // Removes and returns the entry at a given index within the array.
   // If no such entry exists, returns null.
   // Precondition: 0 <= givenIndex < numberOfEntries.
   // Precondition: checkInitialization has been called.
	private T removeEntry(int givenIndex) {
		T result = null;
		
		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];          // Entry to remove
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
			bag[lastIndex] = null;             // Remove reference to last entry
			numberOfEntries--;
		} // end if
		
		return result;
	} // end removeEntry
	
	// Returns true if the array bag is full, or false if not.
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	} // end isArrayFull
	
	// Doubles the size of the array bag.
	// Precondition: checkInitialization has been called.
	private void doubleCapacity() {
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	} // end doubleCapacity
	
	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
											"allowed maximum of " + MAX_CAPACITY);
	} // end checkCapacity
	
	// Throws an exception if receiving object is not initialized.
	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException ("Uninitialized object used " +
											"to call an ArrayBag method.");
	} // end checkInitialization
	
	private boolean isTooBig() {
		if ((numberOfEntries < (bag.length / 2)) && bag.length > 20) {
			return true;
		} else {
			return false;
		}
	}
	
	private void reduceArray() {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[bag.length * (3 / 4)]; // Unchecked cast
		for (int i = 0; i < tempBag.length; i++) {
			tempBag[i] = bag[i];
		}
		bag = tempBag;
	}

} // end ResizableArrayBag

