package ChooseAGameName;

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
		mapGrid[0][0] = new StoryPiece(true, "\n0,0", "you died");
		mapGrid[0][1] = new StoryPiece(false, "\n0,1", null);
		mapGrid[0][2] = new StoryPiece(false, "\n0,2", null);
		mapGrid[0][3] = new StoryPiece(true, "\n0,3", "you died");
		mapGrid[1][0] = new StoryPiece(false, "\n1,0", null);
		mapGrid[1][1] = new StoryPiece(true, "\n1,1", "you died");
		mapGrid[1][2] = new StoryPiece(true, "\n1.2", "you died");
		mapGrid[1][3] = new StoryPiece(false, "\n1,3", null);
		mapGrid[2][0] = new StoryPiece(true, "\n2,0", "you died");
		mapGrid[2][1] = new StoryPiece(true, "\n2,1", "you died");
		mapGrid[2][2] = new StoryPiece(false, "\n2,2", null);
		mapGrid[2][3] = new StoryPiece(false, "\n2,3", null);
		mapGrid[3][0] = new StoryPiece(false, "\n3,0", null);
		mapGrid[3][1] = new StoryPiece(false, "\n3,1", null);
		mapGrid[3][2] = new StoryPiece(false, "\n3,2", null);
		mapGrid[3][3] = new StoryPiece(false, "\n3,3", null);
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
				drawMap();
			} else {
				JOptionPane.showMessageDialog(null, "You've fallen off the map. Please move a different direction.");
			}
		}
		if (buttonPressed == eastButton) {
			if (row <= 2) {
				moveEast();
				drawMap();
			} else {
				JOptionPane.showMessageDialog(null, "You've fallen off the map. Please move a different direction.");
			}
		}
		if (buttonPressed == southButton) {
			if (column <= 2) {
				moveSouth();
				drawMap();
			} else {
				JOptionPane.showMessageDialog(null, "You've fallen off the map. Please move a different direction.");
			}

		}
		if (buttonPressed == westButton) {
			if (row >= 1) {
				moveWest();
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