package MarsRover;

public class Backward extends Command {

    @Override
    public boolean canHandle(Character c) {
        return c == 'b';
    }

    @Override
    public void run(MarsRoverState state) {
        state.setPosition(state.position().add(state.direction().forwardVector().negatedCoordinates()));
    }

}
