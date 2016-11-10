public class HashTable {
	public int tableSize;
	public LinkedNode[] hashtable;
	public int threshhold;
	public int numElements;
	public ArrayList<String> previousElements = new ArrayList<String>();

	private class LinkedNode {
		private String value;
		private LinkedNode next;

		public LinkedNode(String val) {
			value = val;
			next = null;
		}

		public int getValue() {
			return this.value;
		}
	}

	public HashTable(int size){
		tableSize = size;
		hashtable = new LinkedNode[tableSize];
		threshhold = 2 * size;
		numElements = 0;
	}	

	public void HashElement(String element) {
		previousElements.add(element);
		HashEntryNoAdding(element);
	}

	public void HashEntryNoAdding(String element) {
		int hashCode = HashCode(element);
		int index = hashCode % this.tableSize;
		LinkedNode hashEntry = LinkedNode(element);
		LinkedNode linkedList = hashtable[index];
		LinkedNode ptr = linkedList;
		while (ptr.next != null) {
			ptr = ptr.next;
		}
		ptr.next = hashEntry;
		numElements += 1;
		if (numElements >= threshhold) {
			tableSize = threshhold;
			resizeTable();
		}
	}

	public int HashCode(String element) {
		int total = 0;
		int value;
		for (int i = 0; i <= element.length; i += 1) {
			value = int(element.charAt(i)) * 45;
			total += value;
		}

		return total;
	}

	public void resizeTable() {
		hashtable = new LinkedNode[threshhold];
		for (String value: previousElements) {
			HashEntryNoAdding(value);
		}
	}

}