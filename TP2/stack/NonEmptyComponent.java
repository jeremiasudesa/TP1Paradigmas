package stack;

public class NonEmptyComponent extends SuperComponent {

	public boolean isEmpty() {
		return false;
	}

	public void tryPop() {
	}

	public void tryTop() {
	}

	public NonEmptyComponent push(String val) {
		this.top = val;
		this.size++;
		return this;
	}

}