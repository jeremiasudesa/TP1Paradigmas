package MarsRover;

public class North extends Direction {

    public Coordinate2D forwardVector() {
        return new Coordinate2D(0, 1);
    }

    public Direction rightDirection() {
        return new East();
    }

    public Direction leftDirection() {
        return new West();
    }
}
