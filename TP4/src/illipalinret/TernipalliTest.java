package illipalinret;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TernipalliTest{

	@Test
	public void testCantPutTwoPiecesInOnePlace() {
		Game game = originGame();
		assertThrowsLike(Game.positionIsTakenError, () -> game.putOAt(origin()));
	}

	
	@Test
	public void testCantPlaceWhenItsNotThePlayersTurn() {
		assertThrowsLike(Game.notYourTurn, () -> originGame().putXAt(new Position(1,1)));
	}
	
	@Test
	public void testCantSlideWhenGameIsInPuttingPhase() {
		assertThrowsLike(Game.WrongGameState, () -> originGame().slideOto(origin(), new Position(1,1)));
	}
	
	@Test
	public void testGameIsntOverAtStart() {
		assertFalse(originGame().isOver());
	}
	
	@Test
	public void testCantSlideWhenItsNotThePlayersTurn() {
		Game game = slidingGame();
		assertThrowsLike(Game.notYourTurn, () -> game.slideOto(new Position(0,1), new Position(2,2)));
	}
	
	@Test
	public void testCantSlideTwoPiecesInOnePlace() {
		Game game = slidingGame();
		assertThrowsLike(Game.positionIsTakenError, () -> game.slideXto(origin(), new Position(0,1)));
	}
	
	
	public void testCantPutWhenGameIsInSlidingPhase() {
		Game game = slidingGame();
		assertThrowsLike(Game.WrongGameState, () -> game.putXAt(new Position(1,0)));
	}
	
	@Test
	public void testCantSlideWhenPlayerDoesntHavePosition() {
		Game game = slidingGame();
		assertThrowsLike(Game.positionDoesntBelongToPlayer, () -> game.slideXto(new Position(2,0), new Position(1,0)));
	}
	
	@Test
	public void testInvalidMove() {
		Game game = slidingGame();
		assertThrowsLike(Game.invalidMove, () -> game.slideXto(origin(), new Position(2,2)));
	}
	
	@Test
	public void testPlayerXStraightWin() {
		Game game = originGame();
		ArrayList<Position> straightWin = new ArrayList<>(Arrays.asList(new Position(1, 0), new Position(0, 2), new Position(1, 1), new Position(0, 1)));
		assertTrue(putSequence(straightWin, game, 1).XWon());
	}
	
	@Test
	public void testPlayerOStraightWin() {
		Game game = originGame();
		ArrayList<Position> straightWin = new ArrayList<>(Arrays.asList(new Position(2, 0), new Position(1, 1), new Position(0, 2), new Position(2, 2)));
		assertTrue(putSequence(straightWin, game, 1).OWon());
	}
	
	@Test
	public void testPlayerXDiagonalWin() {
		Game game = originGame();
		ArrayList<Position> diagonalWin = new ArrayList<>(Arrays.asList(new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(2, 2)));
		assertTrue(putSequence(diagonalWin, game, 1).XWon());
	}
	
	@Test
	public void testPlayerODiagonalWin() {
		Game game = originGame();
		ArrayList<Position> diagonalWin = new ArrayList<>(Arrays.asList(new Position(1, 2), new Position(1, 1), new Position(2, 0), new Position(2, 2)));
		assertTrue(putSequence(diagonalWin, game, 1).OWon());
	}
	
	@Test
	public void testCantPlacePiecesWhenGameIsOver() {
		Game game = originGame();
		ArrayList<Position> diagonalWin = new ArrayList<>(Arrays.asList(new Position(1, 2), new Position(1, 1), new Position(2, 0), new Position(2, 2)));
		assertThrowsLike(OverState.gameOver, () -> putSequence(diagonalWin, game, 1).putOAt(new Position(2,1)));
	}
	
	@Test
	public void testCantSlidePiecesWhenGameIsOver() {
		Game game = (new Game()).putXAt(new Position(0,2));
		game.putOAt(origin());
		game.putXAt(new Position(1,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(2,0));
		game.putOAt(new Position(2,2));
		assertThrowsLike(OverState.gameOver, () -> game.slideXto(new Position(0,2), new Position(2,1)));
	}
	
	@Test
	public void testSligdingOWin() {
		Game game = originGame();
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(1,2));
		game.slideXto(origin(), new Position(1,0));
		game.slideOto(new Position(1,2), new Position(2,2));
		assertTrue(game.OWon());	
	}
	
	@Test
	public void testSligdingXWin() {
		Game game = originGame();
		game.putOAt(new Position(2,0));
		game.putXAt(new Position(1,1));
		game.putOAt(new Position(2,1));
		game.putXAt(new Position(0,2));
		game.putOAt(new Position(1,2));
		game.slideXto(new Position(1,1), new Position(0,1));
		assertTrue(game.XWon());	
	}
	
	@Test
	public void testOverGameIsntTied() {
		Game game = (new Game()).putXAt(new Position(0,2));
		game.putOAt(origin());
		game.putXAt(new Position(1,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(2,0));
		game.putOAt(new Position(2,2));
		assertFalse(game.isTied());
	}
	
	@Test
	public void testMatchBeingPlayedIsTied() {
		Game game = (new Game()).putXAt(new Position(0,2));
		game.putOAt(origin());
		game.putXAt(new Position(1,2));
		game.putOAt(new Position(1,1));
		game.putXAt(new Position(2,0));
		assertTrue(game.isTied());
	}
	
	@Test
	public void testCantPutPieceOutOfBoard() {
		assertThrowsLike(Game.positionNotInBoard, () -> (new Game()).putXAt(new Position(-1, 200)));
	}
	
	@Test
	public void testCantSlidePieceOutOfBoard() {
		Game game = originGame();
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
	
	private Position origin() {
		return new Position(0,0);
	}
	private Game originGame() {
		return (new Game()).putXAt(origin());
	}

	private Game slidingGame() {
		return originGame().putOAt(new Position(2,0)).putXAt(new Position(1,1)).putOAt(new Position(2,1)).putXAt(new Position(0,2)).putOAt(new Position(0,1));
	}

	@FunctionalInterface
	private interface PutAction {
    	Game apply(Game game, Position position);
	}

	private Game putSequence(ArrayList<Position> putPos, Game g, int playerInd){
		PutAction putXAt = (game, position) -> game.putXAt(position);
		PutAction putOAt = (game, position) -> game.putOAt(position);
		ArrayList<PutAction> funcList = new ArrayList<>(Arrays.asList(putXAt, putOAt));
		for (Position pos : putPos) {
			g = funcList.get(playerInd).apply(g, pos);
			playerInd = 1 - playerInd;
		}
		return g;
	}

}
