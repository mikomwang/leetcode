public class Stack<T> {
	private static class StackNode<T> {
		private StackNode<T> next;
		private T data;

		private StackNode<T>(T item) {
			this.data = item;
		}
	}


	StackNode<T> top;
	
	public void push(T item) {
		StackNode<T> element = new StackNode<T>(item);
		element.next = top;
		top = element;
	}

	public T pop() {
		if (top == null) {
			throw new EmptyStackException;
		}
		T item = top.data;
		top = top.next;
		return item;
	}

	public T peek() {
		if (top == null) {
			throw new EmptyStackException;
		}
		T item = top.data;
		return item;
	}

	public boolean isEmpty() {
		if (top == null) {
			return True;
		}
		return False;
	}




}