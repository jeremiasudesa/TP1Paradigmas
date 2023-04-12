package stack;

public class EmptyComponentStack extends SuperComponent {

	public boolean isEmpty() {
		return true;
	}

	public NonEmptyComponent push(String val) {
		return new NonEmptyComponent().push(val);
	}

	void throwStackEmptyErrorDescriptionError() {
		throw new Error(stackEmptyErrorDescription);
	}

	public void tryPop() {
		throwStackEmptyErrorDescriptionError();
	}

	public void tryTop() {
		throwStackEmptyErrorDescriptionError();
	}

}