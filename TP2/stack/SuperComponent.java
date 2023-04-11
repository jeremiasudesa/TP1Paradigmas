package stack;

public abstract class SuperComponent {
    static public String stackEmptyErrorDescription = "Stack is empty";

    public int size = 0;

    public abstract boolean isEmpty();

    public abstract NonEmptyComponent push(String val);

    public abstract void pop();

    public abstract String top();

    public int size() {
        return size;
    }
}