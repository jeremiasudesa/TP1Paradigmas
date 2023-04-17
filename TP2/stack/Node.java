package stack;

public abstract class Node {
	private String body;
	private Node previous;

	public void tryTop() {
	}

	public void tryPop() {
	}

	public abstract boolean isEmpty();

	public abstract int getTraceLength();

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
