package TheNegativeBoy;

import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JLabel;


public class StoryPiece {

	private boolean isOccupied;
	private String dangerSymbol = "x";
	private String memoryAndStorySymbol = "o";
	private String alreadyBeenThereSymbol = "-";
	private String occupiedSymbol = "^";
	private JComponent symbol;
	public  String story;
	private boolean isDanger;
	private boolean hasBeenThere;
	private String deathStory;


	public StoryPiece(boolean isDanger, String story, String deathStory) {
		this.isDanger = isDanger;
		hasBeenThere = false;
		this.story = story;
		this.deathStory = deathStory;
		if (isDanger) {
			symbol = new JLabel(dangerSymbol);
		} else {
			symbol = new JLabel(memoryAndStorySymbol);
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
	
	public boolean getHasBeenThere() {
		return hasBeenThere;
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
	

	public String getStory() {
		return story;
	}
	public String getDeathStory() {
		return deathStory;
	}

	
}
