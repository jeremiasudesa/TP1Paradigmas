package MarsRover;

public class ErrorCommand extends Command {

    @Override
    public boolean canHandle(Character c) {
        return false;
    }

    @Override
    public void run(MarsRoverState state) {
        throw new UnsupportedOperationException(Command.NoFittingCommandException);
    }

}
