package ChooseAGameName;

import javax.swing.JButton;
import javax.swing.JComponent;

public class MapManager {

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

	}
	
	public   StoryPiece[][] getMap(){
		return mapGrid;
		
	}
	
	public void handleButton(JButton buttonPressed) {
		if (buttonPressed == northButton) {
			moveNorth();
			System.out.println("i moved north");
		}
		if (buttonPressed == eastButton) {
			moveEast();
		}
		if (buttonPressed == southButton) {
			moveSouth();
		}
		if (buttonPressed == westButton) {
			moveWest();
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
	
	
	

