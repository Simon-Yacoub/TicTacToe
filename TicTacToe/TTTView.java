import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TTTView extends JFrame implements TTTListener {
	private TTTButton[][] buttons;
	private TTTModel model;

	public TTTView(TTTModel model) {
		super("Tic Tac Toe");
		this.model = model;
		this.setLayout(new GridLayout(model.BOARD_SIZE, model.BOARD_SIZE));
		buttons = new TTTButton[model.BOARD_SIZE][model.BOARD_SIZE];
		this.initButtons();
		model.addTTTListener(this);
		this.setSize(500, 550);
		this.setVisible(true);
	}

	private void initButtons() {
		for (int i = 0; i < model.BOARD_SIZE; i++) {
			for (int j = 0; j < model.BOARD_SIZE; j++) {
				TTTButton b = new TTTButton(i, j, "");
				buttons[i][j] = b;
				this.add(b);
				b.addActionListener(this);
			}
		}
	}

	@Override
	public void handleTTTEvent(TTTEvent e) {
		updateButton(e.getX(), e.getY(), e.getTurn());
		if (model.isGameWon()) {
			//disable buttons
			for (int i = 0; i < model.BOARD_SIZE; i++) {
				for (int j = 0; j < model.BOARD_SIZE; j++) {
					buttons[i][j].setEnabled(false);
				}
			}
			 int option = JOptionPane.showConfirmDialog(this, "Game Over!\nWould you like to play again?");
			 switch(option) {
			 case 0: reset();
			 break;
			 default:
				 exit();
			 }
		}

	}

	private void exit() {
		System.exit(0);
		
	}

	private void reset() {
		this.dispose();
		new TTTView(new TTTModel());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TTTButton buttonPressed = (TTTButton) e.getSource();
		model.play(buttonPressed.getX(), buttonPressed.getY());
	}

	public void updateButton(int x, int y, boolean turn) {
		if(turn) {
			buttons[x][y].setText("X");
		}else {
			buttons[x][y].setText("O");
		}
	}

	public static void main(String[] args) {
		new TTTView(new TTTModel());
	}

}
