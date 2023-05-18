package MarsRover;

public class Left extends Command {

    @Override
    public boolean canHandle(Character c) {
        return c == 'l';
    }

}
