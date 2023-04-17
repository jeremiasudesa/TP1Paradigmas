package stack;

public class EmptyNode extends Node {

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int getTraceLength() {
		return 0;
	}

	@Override
	public void tryPop() {
		throwStackError();
	}

	@Override
	public void tryTop() {
		throwStackError();
	}

	private void throwStackError() {
		throw new Error(OOStack.stackEmptyErrorDescription);
	}
}
