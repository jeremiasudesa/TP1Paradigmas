package MarsRover;

public class East extends Direction {

    public Coordinate2D forwardVector() {
        return new Coordinate2D(1, 0);
    }

    public Direction rightDirection() {
        return new South();
    }

    public Direction leftDirection() {
        return new North();
    }
}
