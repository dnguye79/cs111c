
public class LinkedBagDriver {
	public static void main(String[] args) {
		
	}
	
	public static void testUnion() {
		String[] s = {"hello", "chicken", "hello"};
		BagInterface<String> aBag = new LinkedBag<String>(s);
		
		String[] s1 = {"chicken", "dog", "cat"};
		BagInterface<String> ae = new LinkedBag<String>(s1);
		
		
		BagInterface<String> aUnion = aBag.union((LinkedBag<String>) ae);
		System.out.println(aUnion.getCurrentSize());
		
		Object[] afa = aUnion.toArray();
		for (int i = 0; i < afa.length; i++) {
			System.out.println(afa[i]);
		}
	}
}

