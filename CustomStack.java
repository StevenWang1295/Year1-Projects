//Steven Wang


public class CustomStack<T> {
	private Node<T> top;
	private int size;

	// Constructor
	public CustomStack() {
		top = null;
		size = 0;
	}

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		newNode.next = top;
		top = newNode;
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		T data = top.data;
		top = top.next;
		size--;
		return data;
	}

	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return top.data;
	}
	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		CustomStack<Bunny> stack = new CustomStack<>();

		stack.push(new Bunny("Fred", "brown"));
		stack.push(new Bunny("Fluffy", "white"));
		stack.push(new Bunny("Jeffy", "red"));
		//stack of bunnies

		System.out.println("Bunny Stack:");
		while (stack.size != 0) {
			System.out.println("A " + stack.peek().getFurColor() + " bunny named " + stack.pop().getName() + " jumped out of a burrow.");
		}
	}

	static class Bunny {
		private String name;
		private String furColor;

		Bunny(String name, String furColor) {
			this.name = name;
			this.furColor = furColor;
		}

		public String getName() {
			return name;
		}

		public String getFurColor() {
			return furColor;
		}
	}

}

