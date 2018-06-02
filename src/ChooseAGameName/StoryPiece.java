package ChooseAGameName;

import java.awt.Color;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jointheleague.leagueinvaders.GamePanel;

public class StoryPiece   {

	private boolean isOccupied;
	private String dangerSymbol = "x";
	private String memorySymbol = "o";
	private String alreadyBeenThereSymbol = "-";
	private JComponent symbol;
	private String story;
	private boolean isDanger;
	private boolean hasBeenThere;
	
	Game gamePanel = new Game();

	public StoryPiece(boolean isDanger, String story) { 
		this.isDanger = isDanger;
		hasBeenThere = false;
		this.story = story;
		//make sure that at some point that you show the story in the JTextArea of the game page (maybe the manager)
		if(isDanger) {
			setToDangerSymbol();
		}else {
			setToMemorySymbol();
		}
	}

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

	public boolean isDead() {
		int deathRoll = new Random().nextInt(5) + 1;
		if (deathRoll <= 3) {
			return false;
		} else {
			return true;
			//add the background?
		}
	}

}