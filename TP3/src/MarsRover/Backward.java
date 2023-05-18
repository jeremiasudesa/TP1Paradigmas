package MarsRover;

public class Backward extends Command {

    @Override
    public boolean canHandle(Character c) {
        return c == 'b';
    }

}
