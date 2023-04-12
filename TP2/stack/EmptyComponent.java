package stack;

public class EmptyComponent extends SuperComponent {

	public boolean isEmpty() {
		return true;
	}

	public NonEmptyComponent push(String val) {
		return new NonEmptyComponent().push(val);
	}

	public void tryPop() {
		throwStackEmptyErrorDescriptionError();
	}

	public void tryTop() {
		throwStackEmptyErrorDescriptionError();
	}

	private void throwStackEmptyErrorDescriptionError() {
		throw new Error(stackEmptyErrorDescription);
	}

}