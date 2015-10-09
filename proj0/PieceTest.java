package checkers61b.test;

import org.junit.Test;
import static org.junit.Assert.*;

import checkers61b.Board;
import checkers61b.Piece;

public class PieceTest{

	@Test
	public void nullParams(){
		new Piece(false, null, 0, 0, null);
	}

	@Test
	public void isFirePiece(){

		Piece F = new Piece(true, null, 0, 0, null);
		boolean result = F.isFire();
		assertTrue(result);
	}

	@Test
	public void isNotFirePiece(){

		Piece F = new Piece(false, null, 0, 0, null);
		boolean result = F.isFire();
		assertFalse(result);

	}

	@Test
	public void side_PieceIsFire(){

		Piece F = new Piece(true, null, 0, 0, null);
		boolean result = F.side();
		assertEquals(0, result);
	}

	@Test
	public void side_PieceIsNotFire(){

		Piece F = new Piece(false, null, 0, 0, null);
		int result = F.side();
		assertEquals(1, result);
	}

	@Test
	public void isKingPiece(){

		Piece F = new Piece(false, null, 0, 0, null);
		boolean result = F.isKing();
		assertFalse(result);
	}
}