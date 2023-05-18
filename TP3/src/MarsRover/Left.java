package MarsRover;

public class Left extends Command {

    @Override
    public boolean canHandle(Character c) {
        return c == 'l';
    }

    @Override
    public void run(MarsRoverState state) {
        state.setDirection(state.direction().leftDirection());
    }

}
