package stack;

public abstract class Node<T> {
	T body;
	Node<T> previous;

	public abstract int getTraceLength();
}
