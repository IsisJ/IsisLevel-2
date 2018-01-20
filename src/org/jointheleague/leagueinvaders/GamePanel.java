package org.jointheleague.leagueinvaders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer timer;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Hi console!");
	}

	public void startGame() {
		timer.start();
	}

}
