package checkers61b;

public class Board{

	private Piece[][] pieces;
	private int currentSide = 0;
	private Piece selectedPiece;
	private int selectedPieceX, selectedPieceY;
	private boolean hasMoved = false;
	private static Coord selectedCoord;

	private class Coord{
		public int x;
		public int y;
		public Coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int N = 8;
		Board board = new Board(false);
		StdDrawPlus.setXscale(0, N);
		StdDrawPlus.setYscale(0, N);
	}
	

	public Board(boolean shouldBeEmpty){
		pieces = new Pieces[8][8];
		if(!shouldBeEmpty){
			boolean isFire = true;
			for(int i = 0; i < 8; i++){
				if (i >= 3){
					isFire = false;
				}

				for(int j = 0; j < 8; j++){
					if((i <= 2 || i >= 5) && (i + j) % 2 == 0){
						String type = "peon";
						if(i == 2 || i == 5)
							type = "bomba";
						if(i == 1 || i == 6)
							type = "escudo";

						pieces[j][i] = new Piece(isFire, j, i, type);

					}

				}
			}

		}

	}

	public Piece pieceAt(int x, int y){
		if(!inBounds(x, y)){
			return null;
		}

		return pieces[x][y];

	}

	public boolean canSelect(int x, int y){

		if(!inBounds(x, y))
			return false;

		boolean result = false;
		Piece piece = pieceAt(x, y);

		
		
	}

	public void select(int x, int y){
		if(selectedPiece == null || (pieceAt(x, y) != null && !hasMoved)){
			selectedPiece = pieceAt(x, y);
			selectedPieceX = x;
			selectedPieceY = y;
		}else{
			selectedPiece.move(x, y);
			selectedPieceX = x;
			selectedPieceY = y;
			hasMoved = true;
		}
	}

	public void place(Piece P, int x, int y){
		if(!inBounds(x,y))
			return;
		pieces[x][y] = p;
	}

	public Piece remove(int x, int y){
		if(!inBounds(x,y)){
			System.out.println("Can´t remove, piece out of bounds");
		}

		Piece p = pieceAt(x, y);

		if(p == null){
			System.out.println("No piece to remove");
			return null;
		}else{
			pieces[x][y] = null;
			return p;
		}
	}

	public boolean canEndTurn(){
		return hasMoved;
	}




}