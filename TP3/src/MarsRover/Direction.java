package MarsRover;

public abstract class Direction {

    public abstract Coordinate2D forwardVector();

    public abstract Direction rightDirection();

    public abstract Direction leftDirection();
}
