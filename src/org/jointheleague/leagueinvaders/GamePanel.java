package org.jointheleague.leagueinvaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject gameObject;
	public void paintComponent(Graphics g) {
		gameObject.draw(g);
	}

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		gameObject = new GameObject(10,10,10,10);
	}

	public void actionPerformed(ActionEvent e) {
		// System.out.println("Hi console!");
		repaint();
		gameObject.update();
		
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Console! A key was Released!!");
	}

}
