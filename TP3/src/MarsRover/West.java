package MarsRover;

public class West extends Direction {

    public Coordinate2D forwardVector() {
        return new Coordinate2D(-1, 0);
    }

    public Direction rightDirection() {
        return new North();
    }

    public Direction leftDirection() {
        return new South();
    }
}
