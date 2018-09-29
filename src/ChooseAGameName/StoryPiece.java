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
	public  String story;
	private boolean isDanger;
	private boolean hasBeenThere;


	public StoryPiece(boolean isDanger, String story) {
		this.isDanger = isDanger;
		hasBeenThere = false;
		this.story = story;
		if (isDanger) {
			symbol = new JLabel(dangerSymbol);
		} else {
			symbol = new JLabel(memorySymbol);
		}
	}

	public void visit(){
		isOccupied = true;
		symbol = new JLabel(occupiedSymbol);
	}
	
	
	public void leaving(){
		isOccupied = false;
		symbol = new JLabel(alreadyBeenThereSymbol);
		hasBeenThere = true;
	}
	
	public boolean getOccupied() {
		return isOccupied;
	}

	public JComponent getSymbol() {

		return symbol;
	}

	public boolean isDead() {
		if (!isDanger) {
			return false;
		}
		if (hasBeenThere) {
			return false;
		}
		int deathRoll = new Random().nextInt(5) + 1;
		if (isDanger && deathRoll <= 3) {
			return false;
		}
		return true;
	}
	
	public int deathCount() {
		int deathCounter = 0;
		if(isDead()) {
			deathCounter = deathCounter+1;
		}
		return deathCounter;
		
	}

	public String getStory() {
		return story;
	}
	
}
