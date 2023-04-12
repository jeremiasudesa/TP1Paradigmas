package stack;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	private Node<SuperComponent> head;

	public OOStack() {
		head = new NonEmptyNode<SuperComponent>(new EmptyComponent());
	}

	public boolean isEmpty() {
		return head.getBody().isEmpty();
	}

	public OOStack push(String value) {
		SuperComponent newComponent = head.getBody().push(value);
		Node<SuperComponent> newNode = new NonEmptyNode<SuperComponent>(newComponent);
		newNode.setPrevious(head);
		head = newNode;
		return this;
	}

	public Object pop() {
		Object ret = head.getBody().getTop();
		head.getBody().tryPop();
		head = head.getPrevious();
		return ret;
	}

	public Object top() {
		head.getBody().tryTop();
		return head.getBody().getTop();
	}

	public int size() {
		return head.getTraceLength();
	}
}
