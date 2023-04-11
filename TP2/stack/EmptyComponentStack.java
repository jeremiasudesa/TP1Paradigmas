package stack;

public class EmptyComponentStack extends SuperComponent {

	public boolean isEmpty() {
		return true;
	}

	public NonEmptyComponent push(String val) {
		return new NonEmptyComponent(val);
	}

	public void pop() {
		throw new Error(stackEmptyErrorDescription);
	}

	public String top() {
		throw new Error(stackEmptyErrorDescription);
	}

}