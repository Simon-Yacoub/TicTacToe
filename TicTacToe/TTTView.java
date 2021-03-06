import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * TTTView is a GUI-based, visual representation of a TTTModel. It's
 * responsibility is to display a TicTacToe window that has a playable
 * TicTacToe board.
 * 
 * @author Simon Yacoub
 * @version 2.0
 */
public class TTTView extends JFrame implements TTTListener {
	private JButton[][] buttons;
	private TTTModel model;

	/**
	 * Constructor for TTTView Displays a TicTacToe window made up of a JFrame with
	 * a grid layout containing TTTButtons
	 * 
	 * @param model
	 *            The model the TTTView is representing
	 */
	public TTTView(TTTModel model) {
		super("Tic Tac Toe");
		this.model = model;
		this.setLayout(new GridLayout(model.BOARD_SIZE, model.BOARD_SIZE));
		buttons = new JButton[model.BOARD_SIZE][model.BOARD_SIZE];
		this.initButtons();
		model.addTTTListener(this);
		this.setSize(500, 550);
		this.setVisible(true);
	}

	/**
	 * Initializes JButtons on the TTTView
	 */
	private void initButtons() {
		for (int y = 0; y < model.BOARD_SIZE; y++) {
			for (int x = 0; x < model.BOARD_SIZE; x++) {
				JButton b = new JButton("");
				b.setIcon(new ImageIcon("Resources/Blank.png"));
				buttons[x][y] = b;
				this.add(b);
				b.addActionListener(this);
			}
		}
	}

	/**
	 * Handles TicTacToe events (I.E. Buttons presses) Also checks if game is won
	 * after a button has been pressed
	 */
	@Override
	public void handleTTTEvent(TTTEvent e) {
		updateButton(e.getX(), e.getY(), e.getTurn());
		if (model.isGameWon()) {
			win();
		} else if (model.isGameTied()) {
			draw();
		}

	}

	private void draw() {
		String drawMessage = "It is a draw! Would you like to play again?";

		// draw popup
		int option = JOptionPane.showConfirmDialog(this, drawMessage);
		switch (option) {
		case 0:
			reset();
			break;
		default:
			exit();
		}

	}

	/**
	 * Called when game is won. Disables all buttons and displays dialog asking if
	 * player would like to play again
	 */
	private void win() {
		// disable buttons
		for (int i = 0; i < model.BOARD_SIZE; i++) {
			for (int j = 0; j < model.BOARD_SIZE; j++) {
				buttons[i][j].setEnabled(false);
			}
		}

		String victoryMessage = model.getPlayerXTurn() ? "Player X Wins!\nWould you like to play again?"
				: "Player O Wins!\nWould you like to play again?";

		// Game Over popup
		int option = JOptionPane.showConfirmDialog(this, victoryMessage);
		switch (option) {
		case 0:
			reset();
			break;
		default:
			exit();
		}

	}

	/**
	 * Delegating exit
	 */
	private void exit() {
		System.exit(0);

	}

	/**
	 * Disposes of current view and creates a new one
	 */
	private void reset() {
		this.dispose();
		new TTTView(new TTTModel());

	}

	/**
	 * Changes state of model
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		for(int y = 0; y < model.BOARD_SIZE; y++) {
			for(int x = 0; x < model.BOARD_SIZE; x++) {
				if(buttonPressed.equals(buttons[x][y])) {
					model.play(x, y);
				}
			}
		}
	}

	/**
	 * Changes text on the buttons to represent Tics on the board
	 * 
	 * @param x
	 *            The x value of the location
	 * @param y
	 *            The y value of the location
	 * @param turn
	 *            The players turn (if(true) player X turn)
	 */
	public void updateButton(int x, int y, boolean turn) {
		if (turn) {
			buttons[x][y].setIcon(new ImageIcon("Resources/X.png"));
		} else {
			buttons[x][y].setIcon(new ImageIcon("Resources/O.png"));
		}
	}

	public static void main(String[] args) {
		new TTTView(new TTTModel());
	}

}
