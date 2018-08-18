package ChooseAGameName;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class MapManager implements ActionListener {

	  StoryPiece[][] mapGrid= new StoryPiece[4][4];
	  
	  JButton northButton = new JButton("N");
	  JButton eastButton = new JButton("E");
	  JButton southButton = new JButton("S");
	  JButton westButton = new JButton("W");
	  
	  int column = 2;
	  int row = 2;
	  
	
	public  MapManager (){
		
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
	
	public   StoryPiece[][] getMap(){
		return mapGrid;
		
	}
	
	public void addCompassActionListeners() {
		northButton.addActionListener(this);
		southButton.addActionListener(this);
		eastButton.addActionListener(this);
		westButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == northButton) {
			moveNorth();
			System.out.println("i moved north");
		}
		if (buttonPressed == eastButton) {
			moveEast();
			System.out.println("i moved east");
		}
		if (buttonPressed == southButton) {
			moveSouth();
			System.out.println("i moved south");
		}
		if (buttonPressed == westButton) {
			moveWest();
			System.out.println("i moved west");
		}
		
	}
	
	public void moveNorth() {
		mapGrid[column = column + 1] [row].visit();
	}
	
	public void moveEast() {
		mapGrid[column] [row = row +1].visit();
	}
	
	public void moveSouth() {
		mapGrid[column = column - 1] [row].visit();
	}
	
	public void moveWest() {
		mapGrid[column] [row = row - 1].visit();
	}

	
	
}
	
	
	

