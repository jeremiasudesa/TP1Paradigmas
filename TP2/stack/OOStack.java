package stack;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	Node<SuperComponent> head;

	public OOStack() {
		// la idea es dejar al fondo un componente vacio que apunta a si mismo
		// entonces, si hacemos pop sobre una lista con un elemento, va a volver a ser
		// un emptyStack
		head = new Node<SuperComponent>(new EmptyComponentStack());
		head.previous = head;
	}

	public boolean isEmpty() {
		return head.data.isEmpty();
	}

	public OOStack push(String value) {
		head.data.push(value);
		return this;
	}

	public Object pop() {
		head.data.pop();
		head = head.previous;
		return head.data.head.data;
	}

	public Object top() {
		return head.data.top();
	}

	public int size() {
		return head.data.size();
	}
}
