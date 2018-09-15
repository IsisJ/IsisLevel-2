package ChooseAGameName;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class MapManager  implements ActionListener  {

	  StoryPiece[][] mapGrid= new StoryPiece[4][4];
	  //StoryPiece storyPiece = new StoryPiece;
	  
	  JButton northButton = new JButton("N");
	  JButton eastButton = new JButton("E");
	  JButton southButton = new JButton("S");
	  JButton westButton = new JButton("W");
	  JPanel mapPanel;
	  GamePanel gamePanel;
	   int column = 2;
	   int row = 2;
	  
	
	public  MapManager (JPanel mapPanel, GamePanel gamePanel){
		this.mapPanel = mapPanel;
		this.gamePanel = gamePanel;
		mapGrid[0][0] = new StoryPiece(true,"hi");
		mapGrid[0][1] = new StoryPiece(false,"hi");
		mapGrid[0][2] = new StoryPiece(false,"hi");
		mapGrid[0][3] = new StoryPiece(true,"hi");
		mapGrid[1][0] = new StoryPiece(false,"hi");
		mapGrid[1][1] = new StoryPiece(true,"hi");
		mapGrid[1][2] = new StoryPiece(true,"hi");
		mapGrid[1][3] = new StoryPiece(false,"hi");
		mapGrid[2][0] = new StoryPiece(true,"hi");
		mapGrid[2][1] = new StoryPiece(true,"hi");
		mapGrid[2][2] = new StoryPiece(false,"hi");
		mapGrid[2][3] = new StoryPiece(false,"hi");
		mapGrid[3][0] = new StoryPiece(false,"hi");
		mapGrid[3][1] = new StoryPiece(false,"hi");
		mapGrid[3][2] = new StoryPiece(false,"hi");
		mapGrid[3][3] = new StoryPiece(false,"hi");
		mapGrid[column][row].visit();
		
		this.addCompassActionListeners();
		
	}
	
	public void drawMap() {	
		StoryPiece[][] grid = getMap();
		mapPanel.removeAll();
		mapPanel.setLayout(new GridLayout(grid.length,grid.length));
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				mapPanel.add(grid[i][j].getSymbol());
				JLabel label = (JLabel)grid[i][j].getSymbol();
				System.out.print(label.getText());
			}
		}
		mapPanel.revalidate();
		
	}
	
	public   StoryPiece[][] getMap(){
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
			moveNorth();
			drawMap();
		}
		if (buttonPressed == eastButton) {
			moveEast();
			drawMap();
		}
		if (buttonPressed == southButton) {
			moveSouth();
			drawMap();
		}
		if (buttonPressed == westButton) {
			moveWest();
			drawMap();
		}
		
	}
	
	private void moveNorth() {
		mapGrid[column] [row].leaving();
		column = column - 1;
		mapGrid[column] [row].visit();
		gamePanel.hideMap();
		gamePanel.ShowStory();
		System.out.println("i moved north");
	}
	
	private void moveEast() {
		mapGrid[column] [row].leaving();
		mapGrid[column] [row = row +1].visit();
		gamePanel.hideMap();
		gamePanel.ShowStory();
		System.out.println("i moved east");
	}
	
	private void moveSouth() {
		mapGrid[column] [row].leaving();
		mapGrid[column = column + 1] [row].visit();
		gamePanel.hideMap();
		gamePanel.ShowStory();
		System.out.println("i moved south");
	}
	
	private void moveWest() {
		mapGrid[column] [row].leaving();
		mapGrid[column] [row = row - 1].visit();
		gamePanel.hideMap();
		gamePanel.ShowStory();
		System.out.println("i moved west");

	}
	
}