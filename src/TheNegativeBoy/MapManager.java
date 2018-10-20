package TheNegativeBoy;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class MapManager implements ActionListener {

	StoryPiece[][] mapGrid = new StoryPiece[4][4];

	JButton northButton = new JButton("N");
	JButton eastButton = new JButton("E");
	JButton southButton = new JButton("S");
	JButton westButton = new JButton("W");
	JPanel mapPanel;
	GamePanel gamePanel;
	int column = 2;
	int row = 2;

	public MapManager(JPanel mapPanel, GamePanel gamePanel) {
		this.mapPanel = mapPanel;
		this.gamePanel = gamePanel;
		mapGrid[0][0] = new StoryPiece(true,
				"\n> Your stomachs growls bringing attention to your sudden hunger. Should you eat now or wait to eat at the party? Either way you think that it would be courteous to bring food to the event; you’ll grab something on your way there.",
				"\n > Your stomache growls reminding you of your hunger. Thinking back you notice that you haven't eaten in days. Right then and there you collapse as you pass out from starvation. \n YOU DIED");
		mapGrid[0][1] = new StoryPiece(false,
				"\n> While picking up some clothes from the dry cleaners, you ask yourself if you should pick out a new outfit for the party. Reaching into your pocket you realize that you is too broke for that and decide to just dig something out of your closet.",
				null);
		mapGrid[0][2] = new StoryPiece(false,
				"\n> Memory: A group of people sit next to you during school. Between all the indistinctive chatter, you hear key phrases like 'I trust you', 'no parents', and 'you’re in charge!'",
				null);
		mapGrid[0][3] = new StoryPiece(false,
				"\n> Your mom won't let you go to the party so you start to stratagies how you will sneak out tonight.",
				null);
		mapGrid[1][0] = new StoryPiece(false,
				"\n> Thought for the day: What did I wear yesterday? I can’t wear the same thing today because that’ll be awkward. Hmm, oh well ",
				null);
		mapGrid[1][1] = new StoryPiece(false, "\n> Your day seems pretty delightful.", null);
		mapGrid[1][2] = new StoryPiece(true,
				"\n> You threw a temper tantrum beacuse you don't feel like doing any chores. Your mom did not appreciate that.",
				"\n> You begin to throw a temper tantrum. As you flailed about in anger you broke your mom's favorite vase. In return your mom super grounds you. \nYOU DIED ");
		mapGrid[1][3] = new StoryPiece(false,
				"\n> Syrians go off as kids scramble. A neighbor must’ve called the cops ", null);
		mapGrid[2][0] = new StoryPiece(true,
				"\n> As you turn the corner you see a single house with bright lights spilling from the windows and loud music that greets the dead of night",
				"you died");
		mapGrid[2][1] = new StoryPiece(true,
				"\n>  Later that day a note was slipped under the front door of the house. It appears to be an invitation to a birthday party later tonight.",
				"\n> An odd beeping sound begins to go off. Slightly confused, you look around until you find the culprit. The invitation. The sound reminds you of a timer on an explosive. Before you can’t do or think anything the invite explodes and takes you out with it. \nYOU DIED ");
		mapGrid[2][2] = new StoryPiece(false, "", null);
		mapGrid[2][3] = new StoryPiece(true,
				"\n> Looking at the party, you can't decide wheather you'll join the party or head home. Going over the list of pros and cons, you stand there upset and frustated that you cannot come to a conclusion.",
				"\n> A major headache develops from too much contemplation. Because you couldn’t decide whether or not to go to the party your brain fried up!\n YOU DIED");
		mapGrid[3][0] = new StoryPiece(false,
				"\n> This party seems out of control. You planned a calmer event of movies and dancing with a short invite list. Now it’s turned into a chaotic event with multiple boomboxes playing all sorts of songs at once. It was way too late to make such commotion.",
				null);
		mapGrid[3][1] = new StoryPiece(true,
				"\n> You still haven't gone inside the house. You continue to stand in conflict.",
				"\n> Standing in the middle of the street wasn’t your brightest moment. As you gaze at the house, a tired driver rolls right over you.\nYOU DIED");
		mapGrid[3][2] = new StoryPiece(false, "\n> You hear loud noises of cheer, laughter, and music near by.", null);
		mapGrid[3][3] = new StoryPiece(false,
				"\n> Someone approaches you and announces himself to be your best friend. He tells you about how great the party is and that you did a great job planning it. He then wanders back to the house.",
				null);
		mapGrid[column][row].visit();

		this.addCompassActionListeners();
		
	}

	public void drawMap() {
		StoryPiece[][] grid = getMap();
		mapPanel.removeAll();
		mapPanel.setLayout(new GridLayout(grid.length, grid.length));
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				mapPanel.add(grid[i][j].getSymbol());
				JLabel label = (JLabel) grid[i][j].getSymbol();
				System.out.print(label.getText());
			}
		}
		mapPanel.revalidate();

	}

	public StoryPiece[][] getMap() {
		return mapGrid;

	}

	private void addCompassActionListeners() {
		northButton.addActionListener(this);
		southButton.addActionListener(this);
		eastButton.addActionListener(this);
		westButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == northButton) {
			if (column >= 1) {
				moveNorth();
				displayEndStory();
				drawMap();
			} else {
				JOptionPane.showMessageDialog(null, "You've fallen off the map. Please move a different direction.");
			}
		}
		if (buttonPressed == eastButton) {
			if (row <= 2) {
				moveEast();
				displayEndStory();
				drawMap();
			} else {
				JOptionPane.showMessageDialog(null, "You've fallen off the map. Please move a different direction.");
			}
		}
		if (buttonPressed == southButton) {
			if (column <= 2) {
				moveSouth();
				displayEndStory();
				drawMap();
			} else {
				JOptionPane.showMessageDialog(null, "You've fallen off the map. Please move a different direction.");
			}

		}
		if (buttonPressed == westButton) {
			if (row >= 1) {
				moveWest();
				displayEndStory();
				drawMap();
			} else {
				JOptionPane.showMessageDialog(null, "You've fallen off the map. Please move a different direction.");
			}
		}

	}

	private void displayStory(StoryPiece newLocation) {
		newLocation.visit();
		if (!newLocation.getHasBeenThere()) {
			boolean amIDead = newLocation.isDead();
			if (!amIDead) {
				String story = newLocation.getStory();
				gamePanel.addText(story);
			} else if (amIDead) {
				String deathStory = newLocation.getDeathStory();
				gamePanel.addText(deathStory);
			}
		}
	
	 }
	
	boolean hasVisitedAllMap() {
		for (int row = 0; row < mapGrid.length ; row++) {
			for (int column = 0; column < mapGrid [row].length; column++) {
				if(mapGrid[column][row].getHasBeenThere() == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void displayEndStory() {
		
		if(hasVisitedAllMap()) {
			gamePanel.hideMap();
			gamePanel.ShowStory();
			gamePanel.addText("\n> There once was a negative boy who was unsure if he should go to this radical party he decided to be square and miss out on four awesome celebrations all at two in the morning.");
		}

	}

	private void showMapOrStoryPage(StoryPiece newLocation) {
		if (!newLocation.getHasBeenThere()) {
			gamePanel.hideMap();
			gamePanel.ShowStory();
		}

	}

	private void moveNorth() {
		mapGrid[column][row].leaving();
		StoryPiece newLocation = mapGrid[column = column - 1][row];
		displayStory(newLocation);
		showMapOrStoryPage(newLocation);
	}

	private void moveEast() {
		mapGrid[column][row].leaving();
		StoryPiece newLocation = mapGrid[column][row = row + 1];
		displayStory(newLocation);
		showMapOrStoryPage(newLocation);
	}

	private void moveSouth() {
		mapGrid[column][row].leaving();
		StoryPiece newLocation = mapGrid[column = column + 1][row];
		displayStory(newLocation);
		showMapOrStoryPage(newLocation);
	}

	private void moveWest() {
		mapGrid[column][row].leaving();
		StoryPiece newLocation = mapGrid[column][row = row - 1];
		displayStory(newLocation);
		showMapOrStoryPage(newLocation);
	}

}