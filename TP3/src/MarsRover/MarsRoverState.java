package MarsRover;

public class MarsRoverState {
    public Direction direction;

    public Coordinate2D position;

    MarsRoverState(Direction _direction, Coordinate2D _initialCoordinate2D) {
        direction = _direction;
        position = _initialCoordinate2D;
    }

    public Direction direction() {
        return direction;
    }

    public Coordinate2D position() {
        return position;
    }

    public void setDirection(Direction _direction) {
        direction = _direction;
    }

    public void setPosition(Coordinate2D _position) {
        position = _position;
    }
}
