package MarsRover;

public abstract class Command {
    public abstract boolean canHandle(Character c);

    public abstract void run(Diretion direction);

    public static void errorCommand() {
        throw new RuntimeException("Execution Error");
    }
}
