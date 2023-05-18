package MarsRover;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

public class MarsRoverTest {

	static final int initialX = 0, initialY = 0;
	static final Direction CardinalDirection = new North();
	static final String command = "fblr";

	@Test
	public void errorCommand() {
		assertThrowsLike(Command.NoFittingCommandException, () -> initialRover().processCommandString("x"));
	}

	@Test
	public void forwardTest() {
		Coordinate2D newCoordinates = new Coordinate2D(0, 1);
		assertEquals(newCoordinates, initialRover().processCommandString("f").state().position());
	}

	@Test
	public void backwardsTest() {
		Coordinate2D newCoordinates = new Coordinate2D(0, -1);
		assertEquals(newCoordinates, initialRover().processCommandString("b").state().position());
	}

	@Test
	public void leftTest() {
		assertEquals(new West(), initialRover().processCommandString("l").state().direction());
	}

	@Test
	public void rightTest() {
		assertEquals(new East(), initialRover().processCommandString("l").state().direction());
	}

	@Test
	public void testRoverPosition() {
		assertEquals(initialCoordinate2d(), initialRover().state().position());
	}

	@Test
	public void testDontMoveWithRotationsOnly() {
		String rotations = "lrlrlrlrlrrrlrlrllllrrlrlr";
		assertEquals(initialCoordinate2d(), initialRover().processCommandString(rotations).state().position());
	}

	@Test
	public void testDontRotateWithMovementOnly() {
		String movement = "bbbbffffbbbbbbfbf";
		assertEquals(new North(), initialRover().processCommandString(movement).state().direction());
	}

	// @Test
	// public void testComplexCommands() {
	// String complexCommandString = "llbbffrff";
	// Coordinate2D desiredCoordinate = new Coordinate2D();
	// }

	private Coordinate2D initialCoordinate2d() {
		return new Coordinate2D(initialX, initialY);
	}

	private MarsRover initialRover() {
		return new MarsRover(CardinalDirection, initialCoordinate2d());
	}

	private void assertThrowsLike(String msg, Executable expressionToEvaluate) {
		assertEquals(msg, assertThrows(Exception.class, expressionToEvaluate).getMessage());
	}

}
