package MarsRover;

public class Right extends Command {

    @Override
    public boolean canHandle(Character c) {
        return c == 'r';
    }

}
