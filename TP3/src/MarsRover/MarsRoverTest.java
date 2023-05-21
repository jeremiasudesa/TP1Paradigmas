package MarsRover;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

public class MarsRoverTest {

	static final int initialX = 0, initialY = 0;
	static final Direction CardinalDirection = new North();

	@Test
	public void testCoordinate2DX() {
		assertEquals(initialCoordinate2D().x, initialX);
	}

	@Test
	public void testCoordinate2DY() {
		assertEquals(initialCoordinate2D().y, initialY);
	}

	@Test
	public void testRoverPosition() {
		assertEquals(initialCoordinate2D(), initialRover().state().position());
	}

	@Test
	public void errorCommand() {
		assertThrowsLike(Command.NoFittingCommandException, () -> initialRover().processCommandString("x"));
	}

	@Test
	public void forwardTest() {
		assertEquals(new Coordinate2D(0, 1), initialRover().processCommandString("f").state().position());
	}

	@Test
	public void backwardsTest() {
		assertEquals(new Coordinate2D(0, -1), initialRover().processCommandString("b").state().position());
	}

	@Test
	public void leftTest() {
		assertTrue(initialRover().processCommandString("l").state().direction() instanceof West);
	}

	@Test
	public void rightTest() {
		assertTrue(initialRover().processCommandString("r").state().direction() instanceof East);
	}

	@Test
	public void testDontMoveWithRotationsOnly() {
		String rotations = "lrlrlrlrlrrrlrlrllllrrlrlr";
		assertEquals(initialCoordinate2D(), initialRover().processCommandString(rotations).state().position());
	}

	@Test
	public void testDontRotateWithMovementOnly() {
		String movement = "bbbbffffbbbbbbfbf";
		assertTrue(initialRover().processCommandString(movement).state().direction() instanceof North);
	}

	@Test
	public void testComplexMovement() {
		String movement = "llfflbb";
		assertEquals(new Coordinate2D(-2, -2), initialRover().processCommandString(movement).state().position());
	}

	@Test
	public void testNonCommutative() {
		String program = "llfflbb", reverseProgram = "bblffll";
		assertNotEquals(initialRover().processCommandString(program),
				initialRover().processCommandString(reverseProgram));
	}

	@Test
	public void undoRotation() {
		assertEquals(initialRover().state().direction(),
				initialRover().processCommandString("l").processCommandString("r").state().direction());
	}

	@Test
	public void undoMovement() {
		assertEquals(initialRover().state().position(),
				initialRover().processCommandString("f").processCommandString("b").state().position());
	}

	private Coordinate2D initialCoordinate2D() {
		return new Coordinate2D(initialX, initialY);
	}

	private MarsRover initialRover() {
		return new MarsRover(CardinalDirection, initialCoordinate2D());
	}

	private void assertThrowsLike(String msg, Executable expressionToEvaluate) {
		assertEquals(msg, assertThrows(Exception.class, expressionToEvaluate).getMessage());
	}

}
