package ChooseAGameName;

import java.awt.Color;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jointheleague.leagueinvaders.GamePanel;

public class StoryPiece {

	private boolean isOccupied;
	private String dangerSymbol = "x";
	private String memorySymbol = "o";
	private String alreadyBeenThereSymbol = "-";
	private String occupiedSymbol = "^";
	private JComponent symbol;
	private String story;
	private boolean isDanger;
	private boolean hasBeenThere;

	public StoryPiece(boolean isDanger, String story) {
		this.isDanger = isDanger;
		hasBeenThere = false;
		this.story = story;
		// make sure that at some point that you show the story in the JTextArea
		// of the game page (maybe the manager)
		if (isDanger) {
			setToDangerSymbol();
		} else {
			setToMemorySymbol();
		}
	}

	public void visit(){
		isOccupied = true;
		symbol = new JLabel(occupiedSymbol);
	}
	
	public void leaving(){
		isOccupied = false;
		symbol = new JLabel(alreadyBeenThereSymbol);
	}
	
	public boolean getOccupied() {
		return isOccupied;
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

	public boolean isDead() {
		if (!isDanger) {
			return false;
		}
		if (hasBeenThere) {
			return false;
		}
		int deathRoll = new Random().nextInt(5) + 1;
		if (isDanger) {
			if (deathRoll <= 3) {
				return false;
			}
		}
		return true;
	}
}
