package stack;

public abstract class Node<T> {
	private T body;
	private Node<T> previous;

	public T getBody() {
		return body;
	}

	public void setBody(T b) {
		body = b;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> p) {
		previous = p;
	}

	public abstract int getTraceLength();
}
