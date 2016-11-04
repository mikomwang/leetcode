// Linked List Implementation

public class LinkedList {

	int nodeValue;
	LinkedList next;


	public LinkedList(int val) {
		nodeValue = val;
		next = null;
	}

	public int getValue() {
		return this.nodeValue;
	}

	public LinkedList getNext() {
		return this.next;
	}

	public String prettyPrint() {
		LinkedList ptr = this;
		StringBuilder result = new StringBuilder();
		while (ptr != null) {
			result.append(ptr.getValue() + " ");
			ptr = ptr.next;
		}
		return result.toString();
	}


	public static void main(String[] args) {
		LinkedList a = new LinkedList(4);
		LinkedList b = new LinkedList(5);
		LinkedList c = new LinkedList(6);
		a.next = b;
		b.next = c;
		System.out.println(a.prettyPrint());
	}
}