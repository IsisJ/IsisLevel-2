package org.jointheleague.leagueinvaders;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Timer;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionBox;

	public GameObject(int x, int y, int width, int height) {
		this.y = y;
		this.x = x;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x,y,width,height);
	}

	public void update() {
	
        collisionBox.setBounds(x, y, width, height);	
	
	}

	public void draw(Graphics g) {
		

	}
}
