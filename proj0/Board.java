package checkers61b;

public class Board{

	private Piece[][] pieces;
	private int currentSide = 0;
	private Piece selectedPiece;
	private int selectedPieceX, selectedPieceY;
	private boolean hasMoved = false;
	private static Coord selectedCoord;

	public static void main(String[] args) {
		int N = 8;
		Board board = new Board(false);
		StdDrawPlus.setXscale(0, N);
		StdDrawPlus.setYscale(0, N);

		while(true){
			drawBoard(board, selectedCoord);
			if(StdDrawPlus.mousePressed()){
				int x = (int) StdDrawPlus.mouseX();
				int y = (int) StdDrawPlus.mouseY();

				if(board.canSelect(x, y)){
					board.select(x, y);
					selectedCoord = board.new Coord(x, y);
				}
			}
			if(StdDrawPlus.isSpacePressed()){
				if(board.hasMoved){
					board.endTurn();
				}
			}
			if(StdDrawPlus.isNPressed()){
				board = new Board(false);
			}

			StdDrawPlus.show(100);

			
		}
	}
	

	private class Coord{
		public int x;
		public int y;
		public Coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	

	public Board(boolean shouldBeEmpty){
		pieces = new Piece[8][8];
		if(!shouldBeEmpty){
			boolean isFire = true;
			for(int i = 0; i < 8; i++){
				if (i >= 3){
					isFire = false;
				}

				for(int j = 0; j < 8; j++){
					if((i <= 2 || i >= 5) && (i + j) % 2 == 0){
						String type = "pawn";
						if(i == 2 || i == 5)
							type = "bomb";
						if(i == 1 || i == 6)
							type = "shield";

						pieces[j][i] = new Piece(isFire, this, j, i, type);

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

		if(selectedPiece == null || (selectedPiece != null && !hasMoved && !selectedPiece.equals(piece))){
			if(piece != null && piece.side() == currentSide){
				result = true;
			}

			if(selectedPiece != null){
				if(selectedPiece.isKing()){
					result = canMoveOrCapture(x, y, result, piece, 0);
					result = canMoveOrCapture(x, y, result, piece, 1);
				}else{
					result = canMoveOrCapture(x, y, result, piece, currentSide);
				}
			}
		}

		if(selectedPiece != null && hasMoved){
			if(selectedPiece.isKing()){
				result = canMoveOrCapture(x, y, result, piece, 0);
				result = canMoveOrCapture(x, y, result, piece, 1);
			}else{
				result = canCapture(x, y, result, piece, currentSide);
			}
		}

		return result;

		
	}

	public int getDirection(int side){
		int direction;
		if(side == 0){
			direction = 1;
		}else{
			direction = -1;
		}

		return direction;

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

	public void place(Piece p, int x, int y){
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

	public String winner(){
		return null;
	}

	public void endTurn(){

		hasMoved = false;
		selectedPiece.doneCapturing();
		selectedPiece = null;
		selectedCoord = null;
	}

	private boolean inBounds(int x, int y){
		if(x >= 8 || x < 0 || y >=8 || y < 0 || (x+y)%2 != 0){
			return false;
		}else{
			return true;
		}
	}

	private boolean canMoveOrCapture(int x, int y, boolean result, Piece piece, int side){
		int direction = getDirection(side);
		if(piece == null && Math.abs(x - selectedPieceX) == 1 && y - selectedPieceY == 1 * direction){
			result = true;
		}

		result = canCapture(x, y, result, piece, side);
		return result;
	}

	private boolean canCapture(int x, int y, boolean result, Piece piece, int side){
		int direction = getDirection(side);
		if(piece == null && Math.abs(x - selectedPieceX) == 2 && y - selectedPieceY == 2 * direction){
			Piece captureCandidate = pieceAt((x + selectedPieceX)/2, (y + selectedPieceY)/2);
			if(captureCandidate != null && captureCandidate.side() != currentSide){
				result = true;
			}
		}
		return result;
	}

	private static void drawBoard(Board b, Coord c){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if((i + j) % 2 == 0){
					if(c != null && c.x == i && c.y == j)
						StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
					else
						StdDrawPlus.setPenColor(StdDrawPlus.GRAY);			
				}
				else
						StdDrawPlus.setPenColor(StdDrawPlus.RED);
                		StdDrawPlus.filledSquare(i + .5, j + .5, .5);	

					Piece piece = b.pieceAt(i, j);
					if(piece != null){
						String fileName = "img\\";
						if(piece.isBomb())
							fileName += "bomb";
						else if(piece.isShield())
							fileName += "shield";
						else
							fileName += "pawn";
						

						if(piece.isFire())
							fileName += "-fire";
						else
							fileName += "-water";
						if(piece.isKing())
							fileName += "-crowned";
						

						fileName += ".png";
						StdDrawPlus.picture(i + .5, j + .5, fileName, 1, 1);

					}
				
			}
		}
	}

	
}
