package illipalinret;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TernipalliTest{
	Game game = new Game();
	
	
	@Test
	public void testOCantStart() {
		assertThrowsLike(Game.notYourTurn, () -> game.putOAt(new Position(0,0)));
	}

	@Test
	public void testCantPutTwoPiecesInOnePlace() {
		game.putXAt(new Position(0,0));
		assertThrowsLike(Game.positionIsTakenError, () -> game.putOAt(new Position(0,0)));
	}
	
	@Test
	public void testCantPlaceWhenItsNotThePlayersTurn() {
		game.putXAt(new Position(0,0));
		assertThrowsLike(Game.notYourTurn, () -> game.putXAt(new Position(1,1)));
	}
	
	@Test
	public void testCantSlideWhenGameIsInPuttingPhase() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(2,2));
		assertThrowsLike(Game.WrongGameState, () -> game.slideXto(new Position(0,0), new Position(1,1)));
	}
	
	@Test
	public void testGameIsntOverAtStart() {
		assertFalse(game.isOver());
	}
	
	@Test
	public void testCantSlideWhenItsNotThePlayersTurn() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(0,1));
		assertThrowsLike(Game.notYourTurn, () -> game.slideOto(new Position(0,1), new Position(2,2)));
	}
	
	@Test
	public void testCantSlideTwoPiecesInOnePlace() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(0,1));
		assertThrowsLike(Game.positionIsTakenError, () -> game.slideXto(new Position(0,0), new Position(0,1)));
	}

	
	public void testCantPutWhenGameIsInSlidingPhase() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(0,1));
		
		assertThrowsLike(Game.WrongGameState, () -> game.putXAt(new Position(1,0)));
	}
	
	@Test
	public void testCantSlideWhenPlayerDoesntHavePosition() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(0,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(1,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(1,2));
		assertThrowsLike(Game.positionDoesntBelongToPlayer, () -> game.slideXto(new Position(1,0), new Position(2,0)));
	}
	
	@Test
	public void testInvalidMove() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(0,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(1,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(1,2));
		assertThrowsLike(Game.invalidMove, () -> game.slideXto(new Position(0,0), new Position(2,2)));
	}
	
	@Test
	public void testPlayerXStraightWin() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(1,0));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(0,1));
		assertTrue(game.hasPlayerXWon());
	}
	
	@Test
	public void testPlayerOStraightWin() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(2,2));
		assertTrue(game.hasPlayerOWon());
	}
	
	@Test
	public void testPlayerXDiagonalWin() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(1,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(1,2));
		game.putXAt(new Position(2,2));
		assertTrue(game.hasPlayerXWon());
	}
	
	@Test
	public void testPlayerODiagonalWin() {
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(0,0));
		game.putXAt(new Position(1,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(2,0));
		game.putOAt(new Position(2,2));
		assertTrue(game.hasPlayerOWon());
	}
	
	@Test
	public void testCantPlacePiecesWhenGameIsOver() {
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(0,0));
		game.putXAt(new Position(1,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(2,0));
		game.putOAt(new Position(2,2));
		assertThrowsLike(OverState.gameOver, () -> game.putXAt(new Position(2,1)));
	}
	
	@Test
	public void testCantSlidePiecesWhenGameIsOver() {
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(0,0));
		game.putXAt(new Position(1,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(2,0));
		game.putOAt(new Position(2,2));
		assertThrowsLike(OverState.gameOver, () -> game.slideXto(new Position(0,2), new Position(2,1)));
	}
	
	@Test
	public void testSligdingOWin() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(1,2));
		game.slideXto(new Position(0,0), new Position(1,0));
		game.slideOto(new Position(1,2), new Position(2,2));
		assertTrue(game.hasPlayerOWon());	
	}
	
	@Test
	public void testSligdingXWin() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(1,2));
		game.slideXto(new Position(1,1), new Position(0,1));
		assertTrue(game.hasPlayerXWon());	
	}
	
	@Test
	public void testOverGameIsntTied() {
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(0,0));
		game.putXAt(new Position(1,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(2,0));
		game.putOAt(new Position(2,2));
		assertFalse(game.isTied());
	}
	
	@Test
	public void testMatchBeingPlayedIsTied() {
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(0,0));
		game.putXAt(new Position(1,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(2,0));
		assertTrue(game.isTied());
	}
	
	@Test
	public void testCantPutPieceOutOfBoard() {
		assertThrowsLike(Game.positionNotInBoard, () -> game.putXAt(new Position(-1, 200)));
	}
	
	@Test
	public void testCantSlidePieceOutOfBoard() {
		game.putXAt(new Position(0,0));
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(1,2));
		assertThrowsLike(Game.positionNotInBoard, () -> game.slideXto(new Position(1,1), new Position(0,100)));
	}

	private void assertThrowsLike(String msg, Executable lambda) {
		assertEquals(msg, assertThrows(Exception.class, lambda).getMessage());
	}
}