package stack;

public abstract class Node {
	private String body;
	private Node previous;

	public void tryActionMeantForNonEmpty() {
	}

	public abstract boolean isEmpty();

	public abstract int getDepth();

	public String getBody() {
		return body;
	}

	public void setBody(String b) {
		body = b;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node p) {
		previous = p;
	}

}
