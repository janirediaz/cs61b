package checkers61b;

public class Piece{

	private boolean isFire;
	private boolean isKing = false;
	private String type;
	private int x;
	private int y;
	private Board board;
	private boolean hasCaptured = false;

	public Piece(boolean isFire, Board b, int x, int y, String type){
		this.isFire = isFire;
		this.type = type;
		this.x = x;
		this.y = y;
		this.board = b;
	}

	public boolean isFire(){
		return isFire;
	}

	public int side(){
		if(isFire){
			return 0;
		}else{
			return 1;
		}
	}

	public boolean isKing(){
		return this.isKing;
	}

	public boolean isBomb(){
		return "bomb".equelas(type);

	}

	public boolean isShield(){
		return "shield".equals(type);
	}

	public boolean hasCaptured(){
		return hasCaptured;
	}
	
}