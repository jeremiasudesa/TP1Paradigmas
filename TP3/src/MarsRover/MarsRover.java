package MarsRover;

import java.util.ArrayList;

public class MarsRover {
	// el state no es correcto y el direction no deberia ser un caracter sino que
	// una clase
	private MarsRoverState state;
	private ArrayList<Command> commandList = new ArrayList();

	public MarsRover(Direction _direction, Coordinate2D _initialCoordinate) {
		state = new MarsRoverState(_direction, _initialCoordinate);
	}

	private void processCommand(Character command) {
		Command thisCommand = commandList.stream().filter((c) -> c.canHandle(command)).findFirst()
				.orElse(new ErrorCommand());

		thisCommand.run(this.state);
	}

	public MarsRover processCommandString(String commandString) {
		for (Character c : commandString.toCharArray())
			this.processCommand(c);
		return this;
	}

	public MarsRoverState state() {
		return state;
	}
}
