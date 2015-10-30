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
	public void IsShield_Null(){
		Piece F = new Piece(false, null, 0, 0, null);
		boolean result = F.isShield();
		assertFalse(result);
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

	@Test
	public void move_BombCapture_RemovesPawnsAndBombs(){
		Board board = new Board(true);
		Piece sut = new Piece(true, board, 6, 0, "bomb");
		Piece firePawn = new Piece(true, board, 6, 0, "pawn");
		Piece fireBomb = new Piece(true, board, 6, 0, "bomb");
		Piece waterPawn = new Piece(false, board, 6, 0, "pawn");
		Piece waterBomb = new Piece(false, board, 6, 0, "bomb");
		
		board.place(sut, 0, 0);
		board.place(firePawn, 3, 1);
		board.place(fireBomb, 3, 3);
		board.place(waterPawn, 1, 1);
		board.place(waterBomb, 1, 3);
		
		F.move(2,2);
		
		assertNull(board.pieceAt(3,3));
		assertNull(board.pieceAt(1,3));
		assertNull(board.pieceAt(1,1));
		assertNull(board.pieceAt(3,1));
		assertNull(board.pieceAt(2,2));
	}

	@Test
	public void move_BombCapture_DoesNotRemoveShields(){
		Board board = new Board(true);
		Piece sut = new Piece(true, board, 0, 0, "bomb");
		Piece fire1 = new Piece(true, board, 3, 1, "shield");
		Piece fire2 = new Piece(true, board, 3, 3, "shield");
		Piece water1 = new Piece(false, board, 1, 1, "shield");
		Piece water2 = new Piece(false, board, 1, 3, "shield");
		
		board.place(sut, 0, 0);
		board.place(fire1, 3, 1);
		board.place(fire2, 3, 3);
		board.place(water1, 1, 1);
		board.place(water2, 1, 3);
		
		F.move(2,2);
		
		assertEquals(board.pieceAt(3,3));
		assertEquals(board.pieceAt(1,3));
		assertEquals(board.pieceAt(3,1));
		assertNull(board.pieceAt(1,1));
		assertNull(board.pieceAt(2,2));
	}
}