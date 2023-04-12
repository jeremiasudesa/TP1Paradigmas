package stack;

public class EmptyComponent extends SuperComponent {

	public NonEmptyComponent push(String val) {
		return new NonEmptyComponent().push(val);
	}

	public void tryPop() {
		throwStackEmptyErrorDescriptionError();
	}

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