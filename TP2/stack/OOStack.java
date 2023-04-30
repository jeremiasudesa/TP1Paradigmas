package stack;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	private Node head;

	public OOStack() {
		head = new EmptyNode();
	}

	public OOStack push(String value) {
		Node newNode = new NonEmptyNode(value);
		newNode.setPrevious(head);
		head = newNode;
		return this;
	}

	public Object pop() {
		Object ret = head.getBody();
		head.tryActionMeantForNonEmpty();
		head = head.getPrevious();
		return ret;
	}

	public Object top() {
		head.tryActionMeantForNonEmpty();
		return head.getBody();
	}

	public boolean isEmpty() {
		return head.isEmpty();
	}

	public int size() {
		return head.getDepth();
	}

}
