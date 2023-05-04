package MarsRover;

public class MarsRoverState {
	static String direction;
	static Coordinate2D position;

	public MarsRoverState(String direction_, int x, int y) {
		direction = direction_;
		position = new Coordinate2D(x, y);
	}
}
