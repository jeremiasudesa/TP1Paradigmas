package MarsRover;

public class South extends Direction {

    public Coordinate2D forwardVector() {
        return new Coordinate2D(0, -1);
    }

    public Direction rightDirection() {
        return new West();
    }

    public Direction leftDirection() {
        return new East();
    }
}
