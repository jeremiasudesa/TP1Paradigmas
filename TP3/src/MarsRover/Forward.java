package MarsRover;

public class Forward extends Command {

    @Override
    public boolean canHandle(Character c) {
        return c == 'f';
    }

    @Override
    public void run(MarsRoverState state) {
        state.setPosition(state.position().add(state.direction().forwardVector()));
    }

}
