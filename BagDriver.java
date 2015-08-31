
/**
 * CS 111C Fall 2015
 * Assignment 2
 * Nguyen, Dao Minh
 */

public class BagDriver {

	public static void main(String[] args) {
		//testUnion();
		testIntersection();
		//testDifference();
	}
	
	public static void testUnion() {
		BagInterface<String> aBag = new ResizableArrayBag<String>(3);
		aBag.add("hello");
		aBag.add("ckekcn");
		aBag.add("ckekcn");
		aBag.add("ckekcn");
		
		BagInterface<String> ae = new ResizableArrayBag<String>(3);
		ae.add("dog");
		ae.add("cat");
		
		BagInterface<String> aUnion = aBag.union((ResizableArrayBag<String>) ae);
		System.out.println(aUnion.getCurrentSize());
		
		Object[] afa = aUnion.toArray();
		for (int i = 0; i < afa.length; i++) {
			System.out.println(afa[i]);
		}
	}
	
	public static void testIntersection() {
		BagInterface<String> aBag = new ResizableArrayBag<String>(3);
		aBag.add("hello");
		aBag.add("dog");
		aBag.add("dog");
		aBag.add("cat");
		
		BagInterface<String> ae = new ResizableArrayBag<String>(3);
		ae.add("dog");
		ae.add("cat");
		
		BagInterface<String> aUnion = aBag.intersection((ResizableArrayBag<String>) ae);
		System.out.println(aUnion.getCurrentSize());
		
		Object[] afa = aUnion.toArray();
		for (int i = 0; i < afa.length; i++) {
			System.out.println(afa[i]);
		}
	}
	
	public static void testDifference() {
		
	}

}
