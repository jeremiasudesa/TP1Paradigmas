package stack;

public class NonEmptyNode<T> extends Node<T> {

	public NonEmptyNode(T b) {
		setBody(b);
		setPrevious(new EmptyNode<T>());
	}

	@Override
	public int getTraceLength() {
		return 1 + getPrevious().getTraceLength();
	}

}
