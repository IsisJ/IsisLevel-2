package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void update() {
        super.update();
		y=y+1;
	}

	public void draw(Graphics g) {

		g.setColor(Color.YELLOW);
		g.drawRect(x , y , width , height );

	}

}
