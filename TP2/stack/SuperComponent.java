package stack;

public abstract class SuperComponent {
	static public String stackEmptyErrorDescription = "Stack is empty";

	private String val;

	public abstract boolean isEmpty();

	public void tryPop() {
	}

	public void tryTop() {
	}

	public void setVal(String t) {
		val = t;
	}

	public String getTop() {
		return val;
	}
}