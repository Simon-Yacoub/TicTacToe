import java.util.EventObject;
/**
 * TTTEvent is an extension of the EventObject class
 * @author Simon Yacoub
 * @version: 2.1
 */
public class TTTEvent extends EventObject{

	private int x;
	private int y;
	private boolean turn;
	private boolean isGameWon;
	
	public TTTEvent(TTTModel source, int x, int y, boolean turn) {
		super(source);
		this.x = x;
		this.y = y;
		this.turn = turn;
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

}
