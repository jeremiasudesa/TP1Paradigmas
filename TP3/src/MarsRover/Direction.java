package MarsRover;

public abstract class Direction {

    public abstract Coordinate2D forwardVector();

    public abstract Direction rightDirection();

    public abstract Direction leftDirection();

    public boolean equals(Object obj) {
        return (obj != null && getClass() == obj.getClass());
    }

}
