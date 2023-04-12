package stack;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	Node<SuperComponent> head;

	public OOStack() {
		head = new NonEmptyNode<SuperComponent>(new EmptyComponent());
	}

	public boolean isEmpty() {
		return head.getBody().isEmpty();
	}

	public OOStack push(String value) {
		SuperComponent newComponent = this.head.getBody().push(value);
		Node<SuperComponent> newNode = new NonEmptyNode<SuperComponent>(newComponent);
		newNode.previous = head;
		head = newNode;
		return this;
	}

	public Object pop() {
		Object ret = head.getBody().getTop();
		head.body.tryPop();
		head = head.previous;
		return ret;
	}

	public Object top() {
		head.body.tryTop();
		return head.getBody().getTop();
	}

	public int size() {
		return head.getTraceLength();
	}
}
