package ChooseAGameName;

import javax.swing.JFrame;

public class Game {
	public static void main(String[] args) {

		
		
		JFrame frame = new JFrame();
		GamePanel panel = new GamePanel();
		frame.add(panel);
		panel.GamePage();
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
}
