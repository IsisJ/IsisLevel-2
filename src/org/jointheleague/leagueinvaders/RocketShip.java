package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class RocketShip extends GameObject {
	Integer speed;
	Integer ySpeed;

	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 0;
		ySpeed = 0;

	}

	public void update() {
		
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

		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

}
