
public class LinkedBagDriver {
	public static void main(String[] args) {
		testConstructor();
		//System.out.println("********************************************");
		testRemoveEvery();
		System.out.println("********************************************");
		testEquals();
		//System.out.println("********************************************");
		testUnion();
	}
	
	public static void testConstructor(){}
	
	public static void testRemoveEvery(){
		String[] s = {"hello", "gag", "hello"};
		LinkedBagInterface<String> b1 = new LinkedBag<String>(s);
		

		System.out.println("Content of bag 1: ");
		Object[] wow1 = b1.toArray();
		for (int i = 0; i < wow1.length; i++) {
			System.out.println(wow1[i]);	
		}
		
		if (((LinkedBag<String>)b1).removeEvery("hello")){
			System.out.println("Content of bag 1 after remove hello: ");
			Object[] wow3 = b1.toArray();
			for (int i = 0; i < wow3.length; i++) {
				System.out.println(wow3[i]);	
			}
		}
	}
	
	public static void testEquals(){}
	
	public static void testUnion() {
		String[] s = {"hello", "gag", "hello"};
		LinkedBagInterface<String> b1 = new LinkedBag<String>(s);
		
		System.out.println("Content of bag 1: ");
		Object[] wow1 = b1.toArray();
		for (int i = 0; i < wow1.length; i++) {
			System.out.println(wow1[i]);	
		}
		
		String[] s1 = {"chicken", "dog", "cat"};
		LinkedBagInterface<String> b2 = new LinkedBag<String>(s1);
		
		System.out.println("Content of bag 2: ");
		Object[] wow2 = b2.toArray();
		for (int i = 0; i < wow2.length; i++) {
			System.out.println(wow2[i]);	
		}
		
		LinkedBagInterface<String> aUnion = b1.union((LinkedBag<String>) b2);
		
		System.out.println("Content of union of bag1 and bag2: ");	
		Object[] afa = aUnion.toArray();
		for (int i = 0; i < afa.length; i++) {
			System.out.println(afa[i]);
		}
	}
}

