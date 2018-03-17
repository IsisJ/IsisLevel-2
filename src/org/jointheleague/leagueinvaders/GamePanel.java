package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	static RocketShip rocket1 = new RocketShip(250,700,50,50); 
	ObjectManager manager = new ObjectManager(rocket1);
	public static BufferedImage alien;
    public static BufferedImage rocket;
    public static BufferedImage bullet;
    public static BufferedImage space;



	

	public void updateMenuState() {

	}

	public void updateGameState() {

		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if(!rocket1.isAlive) {
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
		
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		System.out.println(WIDTH );
		System.out.println(HEIGHT);
		g.drawImage(GamePanel.space, 0, 0,LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
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
		  try {
              alien = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
              rocket = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
              bullet = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
              space = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
      } catch (IOException e) {

              // TODO Auto-generated catch block

              e.printStackTrace();

      }


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
			rocket1.moveRocketLeft();
		}
		else if(e.getKeyCode() == 38) {
			rocket1.moveRocketUp();
		}
		else if(e.getKeyCode() == 39) {
			rocket1.moveRocketRight();
		}
		else if (e.getKeyCode() == 40) {
			rocket1.moveRocketDown();

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

	
			else if(currentState == END_STATE) {
				currentState = MENU_STATE;
				rocket1 = new RocketShip(250,700,50,50);
				manager = new ObjectManager(rocket1);
			}
			else if (currentState > GAME_STATE) {
				currentState = MENU_STATE;
			}
		}
		moveRocketShip(e);
		if(e.getKeyCode() == 32) {
			manager.addProjectile(new Projectile(rocket1.x+rocket1.width/2-5, rocket1.y, 10, 10));
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Console! A key was Released!!");
		rocket1.stopRocketFromMoving();
	}

}
