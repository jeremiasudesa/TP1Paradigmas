package stack;

public class NonEmptyNode<T> extends Node<T> {

	public NonEmptyNode(T _body) {
		this.body = _body;
		previous = new EmptyNode<T>();
	}

	@Override
	public int getTraceLength() {
		return 1 + previous.getTraceLength();
	}

}
