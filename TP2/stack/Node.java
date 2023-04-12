package stack;

public abstract class Node<T> {
	T body;
	Node<T> previous;

	T getBody() {
		return body;
	}

	public abstract int getTraceLength();
}
