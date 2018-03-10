package org.jointheleague.leagueinvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	RocketShip rocketShip;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime;
	int score = 0;

	public ObjectManager(RocketShip rocketShip) {
		this.rocketShip = rocketShip;
	}

	public void update() {
		rocketShip.update();
		for (int i = 0; i < projectiles.size(); i++) {
			System.out.println(i + " ," + projectiles.size());
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			System.out.println(i + " ," + aliens.size());
			aliens.get(i).update();
		}
	}

	public void draw(Graphics g) {
		rocketShip.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

	}

	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	public void addAlien(Alien alien) {
		aliens.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			boolean areYouAlive = projectiles.get(i).isAlive;
			if (!areYouAlive) {
				projectiles.remove(i);
			}

		}
		for (int i = 0; i < aliens.size(); i++) {
			boolean areYouAlive = aliens.get(i).isAlive;
			if (!areYouAlive) {
				aliens.remove(i);
			}
		}
	}

	public void checkCollision() {
		for (Alien a : aliens) {
			if (rocketShip.collisionBox.intersects(a.collisionBox)) {
				rocketShip.isAlive = false;
			}
		}
		for (Alien a : aliens) {
			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					a.isAlive = false;
					score = score + 1;
				}
			}
		}

	}

	public int getScore() {
		return score;
	}

}
