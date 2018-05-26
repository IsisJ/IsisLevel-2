package ChooseAGameName;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class StoryPiece {

	private boolean isOccupied;
	private String dangerSymbol = "x";
	private String memorySymbol = "o";
	private String alreadyBeenThereSymbol = "-";
	private JComponent symbol;
	private boolean isDead;

	public boolean getOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public JComponent getSymbol() {

		return symbol;
	}

	public void setToDangerSymbol() {

		symbol = new JLabel(dangerSymbol);
	}

	public void setToMemorySymbol() {

		symbol = new JLabel(memorySymbol);
	}

	public void setToAlreadyBeenThereSymbol() {

		symbol = new JLabel(alreadyBeenThereSymbol);
	}

	public boolean getDeath() {

		return isDead;
	}

	public void setIsDead() {
		isDead = true;
	}

}
