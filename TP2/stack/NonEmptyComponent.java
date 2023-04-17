package stack;

public class NonEmptyComponent extends SuperComponent {

	public NonEmptyComponent(String val) {
		setVal(val);
	}

	public boolean isEmpty() {
		return false;
	}

}