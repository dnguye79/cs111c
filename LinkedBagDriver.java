/**
 * CS 111C Fall 2015
 * Assignment 3
 * Nguyen, Dao Minh
 */

public class LinkedBagDriver {
	public static void main(String[] args) {
		testRemoveEvery();
		System.out.println("****************************************************");
		testEquals();
		System.out.println("****************************************************");
		testUnion();
	}
	
	public static void testRemoveEvery(){
		String[] s = {"cat", "dog", "kitten", "dog", "pig"};
		LinkedBagInterface<String> b1 = new LinkedBag<String>(s);

		System.out.println("Content of bag 1: ");
		Object[] c1 = b1.toArray();
		for (int i = 0; i < c1.length; i++) {
			System.out.println(c1[i]);	
		}
		
		if (((LinkedBag<String>)b1).removeEvery("kitten")){
			System.out.println("Content of bag 1 after remove kitten: ");
			Object[] c12 = b1.toArray();
			for (int i = 0; i < c12.length; i++) {
				System.out.println(c12[i]);	
			}
		}
	}
	
	public static void testEquals(){
		String[] s = {"hello", "gag", "hello", "dog", "hello", "gag", "pib"};
		LinkedBagInterface<String> b1 = new LinkedBag<String>(s);
		
		System.out.println("Content of bag 1: ");
		Object[] c1 = b1.toArray();
		for (int i = 0; i < c1.length; i++) {
			System.out.println(c1[i]);	
		}
		
		String[] s1 = {"hello", "dog", "hello", "hello", "gag", "pib", "gag"};
		
		LinkedBagInterface<String> b2 = new LinkedBag<String>(s1);
		
		System.out.println("Content of bag 2: ");
		Object[] c2 = b2.toArray();
		for (int i = 0; i < c2.length; i++) {
			System.out.println(c2[i]);	
		}
		
		if (((LinkedBag<String>)b1).equals(b2)){
			System.out.println("bag 1 is equal to bag 2");
		} else {
			System.out.println("bag 1 is not equal to bag 2");
		}
	}
	
	public static void testUnion() {
		String[] s = {"hello", "gag", "hello"};
		LinkedBagInterface<String> b1 = new LinkedBag<String>(s);
		
		System.out.println("Content of bag 1: ");
		Object[] c1 = b1.toArray();
		for (int i = 0; i < c1.length; i++) {
			System.out.println(c1[i]);	
		}
		
		String[] s1 = {"chicken", "dog", "cat"};
		LinkedBagInterface<String> b2 = new LinkedBag<String>(s1);
		
		System.out.println("Content of bag 2: ");
		Object[] c2 = b2.toArray();
		for (int i = 0; i < c2.length; i++) {
			System.out.println(c2[i]);	
		}
		
		LinkedBagInterface<String> aUnion = b1.union((LinkedBag<String>) b2);
		
		System.out.println("Content of union of bag1 and bag2: ");	
		Object[] cu = aUnion.toArray();
		for (int i = 0; i < cu.length; i++) {
			System.out.println(cu[i]);
		}
	}
}

