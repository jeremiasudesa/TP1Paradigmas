package illipalinret;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TernipalliTest{
	Game game = new Game();
	Player X = new Player();
	Player O = new Player();

//	@Test
//	public void test01() {
//		X.addPosition(new Position(0, 0));
//		O.addPosition(new Position(0, 0));
//		assertEquals(X, O );
//	}
	
	@Test
	public void test02() {
		assertEquals(1, 1 );
	}
	
	@Test
	public void test03() {
		game.putXAt(new Position(0, 0));
		assertThrowsLike(Game.notYourTurn, () -> game.putXAt(new Position(1, 0)));
	}
	
	  private void assertThrowsLike(String msg, Executable lambda) {
			 assertEquals(msg, assertThrows(Exception.class, lambda).getMessage());
		  }
}