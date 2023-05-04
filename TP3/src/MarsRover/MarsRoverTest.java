package MarsRover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MarsRoverTest {

	static final int NUM1 = (int) 1e9, NUM2 = (int) 2e7 + 956;

	@Test
	public void testCoordinates2D() {
		Coordinate2D testCoordinate = sampleCoordinate2D();
		assertEquals(testCoordinate.x, NUM1);
		assertEquals(testCoordinate.y, NUM2);
	}

//	@Test
//	public void testCoordinateState() {
//
//	}

	public Coordinate2D sampleCoordinate2D() {
		int num1 = (int) 1e9, num2 = (int) 2e7 + 956;
		return new Coordinate2D(num1, num2);
	}
}
