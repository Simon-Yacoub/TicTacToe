import java.util.EventObject;

public class TTTEvent extends EventObject{

	private int x;
	private int y;
	private boolean turn;
	private boolean isGameWon;
	
	public TTTEvent(TTTModel source, int x, int y, boolean turn, boolean isGameWon) {
		super(source);
		this.x = x;
		this.y = y;
		this.turn = turn;
		this.isGameWon = isGameWon;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getTurn() {
		return turn;
	}

	public boolean isGameWon() {
		return isGameWon;
	}

}
