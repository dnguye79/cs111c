public class Tester {
	public static void main(String[] args) {
		test(testInitialCapacity(), 1);
		test(testDoubleCapacity(), 2);
	}

	public static void test(boolean condition, int value ) {
		if (!condition) {
			System.out.println("test" + value + "is failed");
		}
	}

	public static boolean testInitialCapacity() {
		int capacity = 3;
		SimpleResizableBag bag = new SimpleResizableBag(capacity);
		if (bag.getCapacity() == capacity)
			return true;
		else
			return false;
	}

	public static boolean testDoubleCapacity() {
		int capacity = 4;
		SimpleResizableBag bag = new SimpleResizableBag(capacity);
		bag.doubleCapacity();

		if (bag.getCapacity() == capacity * 2) 
			return true;
		else
			return false;
	}
}