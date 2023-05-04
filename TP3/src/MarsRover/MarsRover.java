package MarsRover;

public class MarsRover {
	MarsRoverState state;

	public MarsRover(String direction, int x, int y) {
		state = new MarsRoverState(direction, x, y);
	}
}
