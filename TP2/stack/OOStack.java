package stack;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	Node<SuperComponent> head;

	public OOStack() {
		head = new Node<SuperComponent>(new EmptyComponentStack());
	}

	public boolean isEmpty() {
		return head.data.isEmpty();
	}

	public OOStack push(String value) {
		SuperComponent newComponent = this.head.data.push(value);
		Node<SuperComponent> newNode = new Node<SuperComponent>(newComponent);
		newNode.previous = head;
		head = newNode;
		return this;
	}

	public Object pop() {
		Object ret = head.data.top;
		head.data.tryPop();
		head = head.previous;
		return ret;
	}

	public Object top() {
		head.data.tryTop();
		return head.data.top;
	}

	public int size() {
		return head.data.size();
	}
}
