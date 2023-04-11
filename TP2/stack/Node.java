package stack;

public class Node<T> {
    T data;
    Node<T> next, previous;

    public Node(T _data) {
        this.data = _data;
    }
}
