package org.jointheleague.leagueinvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	private final int HEIGHT = 800;
	private final int WIDTH = 500;
	GamePanel gamePanel;

	public LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}

	public void setUp() {
		frame.add(gamePanel);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//frame.setVisible(true);
		//frame.setSize(WIDTH, HEIGHT);
		frame.pack();
		gamePanel.startGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		LeagueInvaders invader = new LeagueInvaders();
		invader.setUp();

	}

}
