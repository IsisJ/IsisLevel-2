package ChooseAGameName;

import java.awt.Color;

import javax.swing.JFrame;

public class Game {
	
	GamePanel panel = new GamePanel();
	//GamePanel mapPanel = new GamePanel();

	
	public void CreateGameUI(){

		JFrame frame = new JFrame();
		frame.add(panel);
		//frame.add(mapPanel);
		panel.GamePage();
		//mapPanel.mapPage();
		panel.setBackground(Color.white);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		Game game = new Game();
		game.CreateGameUI();
		
		

		
	}
}
