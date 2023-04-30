package stack;

public class NonEmptyNode extends Node {

	public NonEmptyNode(String b) {
		setBody(b);
		setPrevious(new EmptyNode());
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int getDepth() {
		return 1 + getPrevious().getDepth();
	}

}
