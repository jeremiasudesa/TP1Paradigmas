package stack;

public class EmptyNode<T> extends Node<T> {

	@Override
	public int getTraceLength() {
		return -1;
	}

}
