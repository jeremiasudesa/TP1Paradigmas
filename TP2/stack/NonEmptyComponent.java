package stack;

public class NonEmptyComponent extends SuperComponent {

    public int size = 0;

    public boolean isEmpty() {
        return false;
    }

    public NonEmptyComponent push(String val) {
        Node<String> nuevoNodo = new Node<String>(val);
        head.next = nuevoNodo;
        nuevoNodo.previous = head;
        head = nuevoNodo;
        size++;
        return this;

    }

    public void pop() {
    }

    public String top() {
        return head.data;
    }

}