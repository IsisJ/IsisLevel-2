package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	// GameObject gameObject;

	public void updateMenuState() {

	}

	public void updateGameState() {
		
	}

	public void updateEndState() {
		
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	
	public void drawMenuState (Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK
				);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	public void paintComponent(Graphics g) {
		// gameObject.draw(g);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		// gameObject = new GameObject(10,10,10,10);
	}

	public void actionPerformed(ActionEvent e) {
		// System.out.println("Hi console!");
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();

		}
		repaint();
		// gameObject.update();

	}

	public void startGame() {
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Console! A key was typed!!!");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Console! A key was pressed!");
		if(currentState == MENU_STATE ) {
			currentState = GAME_STATE;
		}
		else if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Console! A key was Released!!");
	}

}
