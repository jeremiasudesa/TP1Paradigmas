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
		NonEmptyComponent newComponent = new NonEmptyComponent();
		newComponent.top = val;
		newComponent.size = size + 1;
		return newComponent;
	}

}