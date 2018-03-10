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
	Font numEnemiesKilled;
	Font enterToRestart;
	RocketShip rocket = new RocketShip(250,700,50,50); 
	ObjectManager manager = new ObjectManager(rocket);
	

	public void updateMenuState() {

	}

	public void updateGameState() {

		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if(!rocket.isAlive) {
			currentState = END_STATE;
		}
		
		
	}

	public void updateEndState() {

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(gameOverFont);
		g.drawString("GAME OVER", 100, 100); 
		g.setFont(numEnemiesKilled);
		g.drawString("You killed "+ manager.getScore()+" enemies", 150, 300);
		g.setFont(enterToRestart);
		g.drawString("Press ENTER to restart", 150, 400);
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
		manager.draw(g);
		
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
		numEnemiesKilled = new Font ("Arial", Font.PLAIN, 20);
		enterToRestart = new Font ("Arial", Font.PLAIN, 20);
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
	
	public void moveRocketShip(KeyEvent e) {
		if(e.getKeyCode() == 37) {
			rocket.moveRocketLeft();
		}
		else if(e.getKeyCode() == 38) {
			rocket.moveRocketUp();
		}
		else if(e.getKeyCode() == 39) {
			rocket.moveRocketRight();
		}
		else if (e.getKeyCode() == 40) {
			rocket.moveRocketDown();

		}
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
		moveRocketShip(e);
		if(e.getKeyCode() == 32) {
			manager.addProjectile(new Projectile(rocket.x+rocket.width/2-5, rocket.y, 10, 10));
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Console! A key was Released!!");
		rocket.stopRocketFromMoving();
	}

}
