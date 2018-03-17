package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class RocketShip extends GameObject {
	Integer speed;
	Integer ySpeed;
	RocketShip drawRocket;

	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 0;
		ySpeed = 0;

	}

	public void update() {
        super.update();
		x = x + speed;
		y = y + ySpeed;
		

	}

	
	public void moveRocketLeft() {
		speed = - 5;

	}

	public void moveRocketRight() {
		speed =  + 5;

	}

	public void moveRocketUp() {
		ySpeed =  - 5;

	}

	public void moveRocketDown() {
		ySpeed =   5;

	}
	public void stopRocketFromMoving() {
		speed = 0;
		ySpeed = 0;
	}

	public void draw(Graphics g) {

		//g.setColor(Color.BLUE);
		//g.fillRect(x, y, width, height);
		  g.drawImage(GamePanel.rocket, x, y, width, height, null);
		 // g.drawImage(GamePanel.space, x, y, width, height, null);
	}
	
	public void drawTheLoop(Graphics g) {
		  g.drawImage(GamePanel.rocket, 0, y, width, height, null);
	}

}
