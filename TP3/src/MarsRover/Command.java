package MarsRover;

public abstract class Command {
    public static String NoFittingCommandException = "No command matches the given character";

    public abstract boolean canHandle(Character c);

    public abstract void run(MarsRoverState state);

}
