package org.jointheleague.leagueinvaders;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	RocketShip rocketShip;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public ObjectManager(RocketShip rocketShip) {
		this.rocketShip = rocketShip;
	}
	
	public void update() {
		rocketShip.update();
		for(int i=0; i<projectiles.size(); i++) {
			System.out.println(i +" ," + projectiles.size());
			projectiles.get(i).update();
		}
	}
	
	public void draw(Graphics g) {
		rocketShip.draw(g);
		for(int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	
}
