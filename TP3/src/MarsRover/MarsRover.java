package MarsRover;

import java.util.ArrayList;
import java.util.Map;

public class MarsRover {
	// el state no es correcto y el direction no deberia ser un caracter sino que
	// una clase
	private Direction direction;
	private Coordinate2D position;
	private ArrayList<Command> commandList = new ArrayList();

	public MarsRover(Direction _direction, Coordinate2D _initialCoordinate) {
		direction = _direction;
		position = _initialCoordinate;
	}

	private MarsRover processCommand(Character command) {
		Command thisCommand = commandList.stream().filter((c) -> c.canHandle(command)).findFirst()
				.orElse(errorCommand());

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
