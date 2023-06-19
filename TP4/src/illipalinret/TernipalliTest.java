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
		assertThrowsLike(Game.positionIsTakenError, () -> originGame().putOAt(origin()));
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
		assertThrowsLike(Game.notYourTurn, () -> slidingGame().slideOto(new Position(0,1), new Position(2,2)));
	}
	
	@Test
	public void testCantSlideTwoPiecesInOnePlace() {
		assertThrowsLike(Game.positionIsTakenError, () -> slidingGame().slideXto(origin(), new Position(0,1)));
	}
	
	public void testCantPutWhenGameIsInSlidingPhase() {
		assertThrowsLike(Game.WrongGameState, () -> slidingGame().putXAt(new Position(1,0)));
	}
	
	@Test
	public void testCantSlideWhenPlayerDoesntHavePosition() {
		assertThrowsLike(Game.positionDoesntBelongToPlayer, () -> slidingGame().slideXto(new Position(2,0), new Position(1,0)));
	}
	
	@Test
	public void testInvalidMove() {
		assertThrowsLike(Game.invalidMove, () -> slidingGame().slideXto(origin(), new Position(2,2)));
	}
	
	@Test
	public void testPlayerXStraightWin() {
		ArrayList<Position> straightWin = new ArrayList<>(Arrays.asList(new Position(1, 0), new Position(0, 2), new Position(1, 1), new Position(0, 1)));
		assertTrue(putSequence(straightWin, originGame(), 1).XWon());
	}

	@Test
	public void testPlayerXVerticalWin() {
		ArrayList<Position> straightWin = new ArrayList<>(Arrays.asList(new Position(1, 1), new Position(1, 0), new Position(2, 1), new Position(2, 0)));
		assertTrue(putSequence(straightWin, originGame(), 1).XWon());
	}
	
	@Test
	public void testPlayerOStraightWin() {
		ArrayList<Position> straightWin = new ArrayList<>(Arrays.asList(new Position(2, 0), new Position(1, 1), new Position(2, 1), new Position(0, 2), new Position(2,2)));
		assertTrue(putSequence(straightWin, originGame(), 1).OWon());
	}

	@Test
	public void testPlayerOVerticalWin() {
		ArrayList<Position> straightWin = new ArrayList<>(Arrays.asList(new Position(0,1), new Position(1, 2),new Position(1, 1), new Position(0, 2), new Position(2, 1)));
		assertTrue(putSequence(straightWin, originGame(), 1).OWon());
	}

	@Test
	public void testPlayerXDoesntDiagonalWin() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(1, 0), new Position(2, 0), new Position(1, 2), new Position(1, 1), new Position(0, 2)));
		assertFalse(putSequence(positions, originGame(), 1).XWon());
	}

	@Test
	public void testPlayerXDoesntDiagonalWin2() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(2, 0)));
		assertFalse(putSequence(positions, originGame(), 1).XWon());
	}

	@Test
	public void testPlayerXDiagonalWin() {
		ArrayList<Position> diagonalWin = new ArrayList<>(Arrays.asList(new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(2, 2)));
		assertTrue(putSequence(diagonalWin, originGame(), 1).XWon());
	}
	
	@Test
	public void testPlayerOInverseDiagonalWin() {
		ArrayList<Position> diagonalWin = new ArrayList<>(Arrays.asList(new Position(0,2), new Position(1,2),new Position(1,1), new Position(2,1), new Position(2,0)));
		assertTrue(putSequence(diagonalWin, originGame(), 1).OWon());
	}

	@Test
	public void testPlayerODiagonalWin() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(0, 2), new Position(0, 0),new Position(1, 2),new Position(1, 1),new Position(2, 0),new Position(2, 2)));
		assertTrue(putSequence(positions, new Game(), 0).OWon());
	}

	
	@Test
	public void testCantPlacePiecesWhenGameIsOver() {
		ArrayList<Position> diagonalWin = new ArrayList<>(Arrays.asList(new Position(1, 2), new Position(1, 1), new Position(2, 0), new Position(2, 2)));
		assertThrowsLike(OverState.gameOver, () -> putSequence(diagonalWin, originGame(), 1).putOAt(new Position(2,1)));
	}
	
	@Test
	public void testCantSlidePiecesWhenGameIsOver() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(0, 2),new Position(0, 0),new Position(1, 2),new Position(1, 1),new Position(2, 0),new Position(2, 2)));
		assertThrowsLike(OverState.gameOver, () -> putSequence(positions, new Game(), 0).slideXto(new Position(0,2), new Position(2,1)));
	}
	
	@Test
	public void testSligdingOWin() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(2, 0),new Position(1, 1),new Position(2, 1),new Position(0, 2),new Position(1, 2)));
		Game game = putSequence(positions, originGame(), 1);
		game.slideXto(origin(), new Position(1,0));
		game.slideOto(new Position(1,2), new Position(2,2));
		assertTrue(game.OWon());
	}

	@Test
	public void testSligdingXWin() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(2, 0),new Position(1, 1),new Position(2, 1),new Position(0, 2),new Position(1, 2)));
		Game game = putSequence(positions, originGame(), 1);
		game.slideXto(new Position(1,1), new Position(0,1));
		assertTrue(game.XWon());
	}

	@Test
	public void testOverGameIsntTied() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(0, 2),new Position(0, 0),new Position(1, 2),new Position(1, 1),new Position(2, 0),new Position(2, 2)));
		assertFalse(putSequence(positions, new Game(), 0).isTied());
	}

	@Test
	public void testMatchBeingPlayedIsTied() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(0, 2),new Position(0, 0),new Position(1, 2),new Position(1, 1),new Position(2, 0)));
		assertTrue(putSequence(positions, new Game(), 0).isTied());
	}

	@Test
	public void testCantPutPieceOutOfBoard() {
		assertThrowsLike(Game.positionNotInBoard, () -> (new Game()).putXAt(new Position(-1, 200)));
	}
	
	@Test
	public void testCantSlidePieceOutOfBoard() {
		ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(2, 0),new Position(1, 1),new Position(2, 1),new Position(0, 2),new Position(1, 2)));
		assertThrowsLike(Game.positionNotInBoard, () -> putSequence(positions, originGame(), 1).slideXto(new Position(1,1), new Position(0,100)));
	}

	private void assertThrowsLike(String msg, Executable lambda) {assertEquals(msg, assertThrows(Exception.class, lambda).getMessage());}
	private Position origin() {return new Position(0,0);}
	private Game originGame() {return (new Game()).putXAt(origin());}
	private Game slidingGame() {return originGame().putOAt(new Position(2,0)).putXAt(new Position(1,1)).putOAt(new Position(2,1)).putXAt(new Position(0,2)).putOAt(new Position(0,1));}

	private Game putSequence(ArrayList<Position> putPos, Game game, int playerInd){
		for (Position position : putPos) {
			game = (playerInd == 0 ? game.putXAt(position) : game.putOAt(position));
			playerInd = 1 - playerInd;
		}
		return game;
	}
}
