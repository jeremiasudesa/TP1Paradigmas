package stack;

public class NonEmptyComponent extends SuperComponent {

	Node<String> head;

	public NonEmptyComponent(String data) {
		head = new Node<String>(data);
	}

	public boolean isEmpty() {
		return false;
	}

	public NonEmptyComponent push(String val) {
		Node<String> nuevoNodo = new Node<String>(val);
		head.next = nuevoNodo;
		nuevoNodo.previous = head;
		head = nuevoNodo;
		size++;
		return this;

	}

	public void pop() {
	}

	public String top() {
		return head.data;
	}

}