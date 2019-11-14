import java.util.ArrayList;
import java.util.List;

public class TTTModel {
	protected static final int BOARD_SIZE = 3;
	private char[][] grid;
	private boolean playerXTurn;
	private List<TTTListener> tttModelListeners;

	public TTTModel() {
		playerXTurn = true;
		tttModelListeners = new ArrayList();

		// initialize grid of chars
		grid = new char[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				grid[i][j] = ' ';
			}
		}

	}

	public void addTTTListener(TTTListener ttl) {
		tttModelListeners.add(ttl);
	}

	public void play(int x, int y) {
		if ((x < 3) && (y < 3) && (x >= 0) && (y >= 0)) {
			if (grid[x][y] == ' ') {
				if (playerXTurn) {
					grid[x][y] = 'X';
					notifyListeners(x, y);
					playerXTurn = !playerXTurn;
				}else {
					grid[x][y] = 'O';
					notifyListeners(x, y);
					playerXTurn = !playerXTurn;
				}
			}
		}else {
			System.out.println("Incorrect Location");
		}
	}
	
	public boolean isGameWon() {
		//TODO come up with better win condition checking
		
		//Check Rows
		for(int y = 0; y < BOARD_SIZE; y++) {
			if(grid[0][y] == 'X' && grid[1][y] == 'X' && grid[2][y] == 'X') {
				return true;
			}else if(grid[0][y] == 'O' && grid[1][y] == 'O' && grid[2][y] == 'O') {
				return true;
			}
		}
		
		//Check Columns
		for(int x = 0; x < BOARD_SIZE; x++) {
			if(grid[x][0] == 'X' && grid[x][1] == 'X' && grid[x][2] == 'X') {
				return true;
			}else if(grid[x][0] == 'O' && grid[x][1] == 'O' && grid[x][2] == 'O') {
				return true;
			}
		}
		
		//Check Diagonals 
		if(grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
			return true;
		}else if(grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
			return true;
		}
		
		if(grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == 'X') {
			return true;
		}else if(grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == 'O') {
			return true;
		}
		
		return false;
	}
	
	public boolean getPlayerXTurn() {
		return playerXTurn;
	}
	
	public void notifyListeners(int x, int y) {
		TTTEvent event = new TTTEvent(this, x, y, playerXTurn, isGameWon());
		for(TTTListener listener  : tttModelListeners) {
			listener.handleTTTEvent(event);
		}
	}
	
	public char[][] getGrid(){
		return grid;
	}

	public static void main(String[] args) {
		new TTTModel();
	}
}
