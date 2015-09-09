
public class LinkedStringBag {
	private class Node {
		public Node next;
		public String data;
		
		public Node(String s, Node nNode) {
			data = s;
			next = nNode;
		}
		
		public Node(String s) {
			this(s, null);
		}
	}
	
	private Node head;
	private int size;
	
	public LinkedStringBag() {
		head = null;
		size = 0;
	}
	
	public int getCurrentSize() {
		return size;
	}
	
	public void add(String s) {
		Node newNode = new Node(s);
		newNode.data = s;
		//newNode.next = null;
		
		if (size == 0) {
			head = newNode;
		} else { // add to end of list
			Node tail = head;
			while (tail.next != null)
				tail = tail.next;
			tail.next = newNode;
		}
		
		size++;
	}
	
	public boolean contains(String s) {
		return true;
	}
	
	public int getActualNodeCount() {
		return 0;
	}
	
	public static void main(String[] args) {
		String sl = "red", s2 = "green";
		LinkedStringBag b = new LinkedStringBag();
		
		if (b.getCurrentSize() != 0) {
			System.out.println("failed");
		}
		
		b.add(sl);
		if (b.getCurrentSize() != 1) {
			System.out.println("failed");
		}
		
		b.add(s2);
		
		if (b.getCurrentSize() != 2) {
			System.out.println("failed");
		}
		
	}
}
