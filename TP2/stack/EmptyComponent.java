package stack;

public class EmptyComponent extends SuperComponent {

	@Override
	public void tryPop() {
		throwStackEmptyErrorDescriptionError();
	}

	@Override
	public void tryTop() {
		throwStackEmptyErrorDescriptionError();
	}

	public boolean isEmpty() {
		return true;
	}

	private void throwStackEmptyErrorDescriptionError() {
		throw new Error(stackEmptyErrorDescription);
	}

}