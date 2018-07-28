package ChooseAGameName;

import javax.swing.JButton;
import javax.swing.JComponent;

public class MapManager {

	  StoryPiece[][] mapGrid= new StoryPiece[4][4];
	  
	  JButton northButton = new JButton("N");
	  JButton eastButton = new JButton("E");
	  JButton southButton = new JButton("S");
	  JButton westButton = new JButton("W");
	  
	
	public  MapManager (){
		
		mapGrid[0][0] = new StoryPiece(true,"x");
		mapGrid[0][1] = new StoryPiece(false,"o");
		mapGrid[0][2] = new StoryPiece(false,"o");
		mapGrid[0][3] = new StoryPiece(true,"x");
		mapGrid[1][0] = new StoryPiece(false,"o");
		mapGrid[1][1] = new StoryPiece(true,"x");
		mapGrid[1][2] = new StoryPiece(true,"x");
		mapGrid[1][3] = new StoryPiece(false,"o");
		mapGrid[2][0] = new StoryPiece(true,"x");
		mapGrid[2][1] = new StoryPiece(true,"x");
		mapGrid[2][2] = new StoryPiece(false,"o");
		mapGrid[2][3] = new StoryPiece(false,"o");
		mapGrid[3][0] = new StoryPiece(false,"o");
		mapGrid[3][1] = new StoryPiece(false,"o");
		mapGrid[3][2] = new StoryPiece(false,"o");
		mapGrid[3][3] = new StoryPiece(false,"o");

	}
	
	public   StoryPiece[][] getMap(){
		return mapGrid;
		
	}
	
	
	
}
