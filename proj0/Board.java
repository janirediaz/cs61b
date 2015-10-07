package checkers61b;

public class Board{

	private Piece[][] pieces;

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
		
	}
}