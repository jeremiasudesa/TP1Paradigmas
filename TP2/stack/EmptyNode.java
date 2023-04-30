package stack;

public class EmptyNode extends Node {

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int getDepth() {
		return 0;
	}

	@Override
	public void tryActionMeantForNonEmpty() {
		throw new Error(OOStack.stackEmptyErrorDescription);
	}
}
