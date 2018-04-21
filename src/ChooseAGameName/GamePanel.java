package ChooseAGameName;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GamePanel extends JPanel {

	// graphics and layout for each page ( game page, and map); maybe handle mouse clicks(for map)
	
	//JTextArea storyArea = new JTextArea("hey", 1, 1);
	JTextArea storyArea = new JTextArea(">Hello, how are you doing today?!\n\n\n\n\n\n\n\nsome text\n\n\n\n\n\n\n\n even more text", 10,10);
	JLabel deathCount = new JLabel("Deaths: put num later");
	JScrollPane scroll = new JScrollPane(storyArea);

	public void GamePage() {
		// panel= new GridLayout(3,1);
		storyArea.setEditable(false);
		this.add(scroll);
		this.add(deathCount);
		storyArea.setLineWrap(true);
		storyArea.setWrapStyleWord(true);

	}

	public void Map() {

	}

}
