package MarsRover;

public class Coordinate2D {
	public int x, y;

	public Coordinate2D(int x_, int y_) {
		x = x_;
		y = y_;
	}

	public Coordinate2D add(Coordinate2D otherCoordinate) {
		x += otherCoordinate.x;
		y += otherCoordinate.y;

		return this;
	}

	public Coordinate2D negatedCoordinates() {
		this.x = -1 * this.x;
		this.y = -1 * this.y;
		return this;
	}

	public boolean equals(Object o) {
		return (o != null && (o.getClass() == this.getClass()) && ((Coordinate2D) o).x == x
				&& ((Coordinate2D) o).y == y);
	}
}
