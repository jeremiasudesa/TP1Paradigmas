package stack;

public abstract class SuperComponent {
    static public String stackEmptyErrorDescription = "Stack is empty";

    public int size = 0;
    public String top;

    public abstract boolean isEmpty();

    public abstract NonEmptyComponent push(String val);

    public abstract void tryPop();

    public abstract void tryTop();

    public int size() {
        return size;
    }
}