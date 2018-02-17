package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Font;
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
	Font titleFont;
	Font gameOverFont;
	Font enterToStartFont;
	Font spaceForInstructionFont;
	
	
	

	public void updateMenuState() {

	}

	public void updateGameState() {

	}

	public void updateEndState() {

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(gameOverFont);
		g.drawString("GAME OVER", 95, 400);
	}
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("League Invaders", 55, 100);
		g.setFont(enterToStartFont);
		g.drawString("Press ENTER to start", 50, 300);
		g.setFont(spaceForInstructionFont);
		g.drawString("Press SPACE for instructions", 50, 400);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	
	
	public void paintComponent(Graphics g) {
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
		titleFont = new Font("Arial", Font.PLAIN, 48);
		gameOverFont = new Font("Arial", Font.PLAIN, 48);
		enterToStartFont = new Font("Arial", Font.PLAIN, 20);
		spaceForInstructionFont = new Font("Arial", Font.PLAIN, 20);
		
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
		if(e.getKeyCode() == 10 ) {
		//System.out.println(e.getKeyCode());
		//enter key code is 10
			if(currentState == MENU_STATE ) {
				currentState = GAME_STATE;
			}
	
			else if(currentState < END_STATE) {
				currentState = END_STATE;
			}
			else if (currentState > GAME_STATE) {
				currentState = MENU_STATE;
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Console! A key was Released!!");
	}

}
