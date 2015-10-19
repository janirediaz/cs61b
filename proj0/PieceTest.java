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

	@Test
	public void isShield_Type(){

		Piece F = new Piece(false, null, 0, 0, "shield");
		boolean result = F.isShield();
		assertTrue(result);
	}

	@Test
	public void isPawn_Type(){

		Piece F = new Piece(false, null, 0, 0, "pawn");
		boolean result = F.isPawn();
		assertTrue(result);
	}

	@Test
	public void isBomb_Type(){

		Piece F = new Piece(false, null, 0, 0, "bomb");
		assertTrue(result);
	}

	@Test
	public void move_MoveToEmptySpace(){

		Board board = new Board(true);
		Piece F = new Piece(false, board, 0, 0, "pawn");
		board.place(F, 0, 0);

		F.move(1, 1);
		assertEquals(board.pieceAt(1, 1) , F);
		aseertNull(board.pieceAt(0, 0));
	}

	@Test
	public void move_ToLastRow(){
		Board board = new Board(true);
		Piece F = new Piece(true, board, 6, 0, "pawn");
		board.place(F, 0, 6);
		F.move(1 ,7);
		assertEquals(board.pieceAt(1, 7), F);
		assertTrue(F.isKing());
	}
}