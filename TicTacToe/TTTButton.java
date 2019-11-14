
import javax.swing.JButton;

public class TTTButton extends JButton{
	private int x;
	private int y;
	
	public TTTButton(int x, int y, String s) {
		super(s);
		this.x = x;
		this.y = y;
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


}
