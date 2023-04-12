package stack;

public class NonEmptyComponent extends SuperComponent {

	public void tryPop() {
	}

	public void tryTop() {
	}

	public NonEmptyComponent push(String val) {
		NonEmptyComponent newComponent = new NonEmptyComponent();
		newComponent.setTop(val);
		return newComponent;
	}

	public boolean isEmpty() {
		return false;
	}

}