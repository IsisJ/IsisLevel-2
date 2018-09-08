package ChooseAGameName;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GamePanel extends JPanel implements ActionListener {

	// JTextArea storyArea = new JTextArea("hey", 1, 1);
	JTextArea storyArea = new JTextArea(
			">Hello, how are you doing today?!\n\n\n\n\n\n\n\nsome text\n\n\n\n\n\n\n\n even more text", 20, 30);
	StoryPiece storyPiece = new StoryPiece(false, "hey");
	JLabel deathCount = new JLabel("Deaths: "+storyPiece.deathCount());
	JScrollPane scroll = new JScrollPane(storyArea);
	JButton mapButton = new JButton();
	JLabel map = new JLabel("You're in the map");

	int storyState = 1;
	int mapState = 2;
	int currentState = storyState;
	JPanel mapPanel = new JPanel();
	MapManager mapManager = new MapManager(mapPanel);
	JPanel compassPanel = new JPanel();


	public void gamePage() {
		storyArea.setEditable(false);
		this.add(scroll);
		this.add(deathCount);
		storyArea.setLineWrap(true);
		storyArea.setWrapStyleWord(true);
		scroll.setBorder(null);
		this.add(mapButton);
		mapButton.setText("Map");
		mapButton.addActionListener(this);	
		/*
		Story Piece Test
		this.add(storyPiece.getSymbol());
		this.add(storyPiece2.getSymbol());
		End of Piece Test
		isDead Test
		*/
		/*
		System.out.println(storyPiece.isDead());
		System.out.println(storyPiece2.isDead());
		End of isDead
		*/
		this.add(mapPanel);
		mapPanel.setVisible(false);
		mapPanel.setPreferredSize(new Dimension (300,300));
		this.add(compassPanel);
		compassPanel.setVisible(false);
		compassPanel.setPreferredSize(new Dimension (100,100));
		this.add(map).setVisible(false);
		this.compassPage();
		this.mapManager.drawMap();

	}
	
	
	
	public void compassPage(){
		JLabel empty = new JLabel("  ");
		JLabel empty2 = new JLabel("  ");
		JLabel empty3 = new JLabel("  ");
		JLabel empty4 = new JLabel("  ");

		compassPanel.setLayout(new GridLayout(3,3));
		compassPanel.add(new JPanel());
		compassPanel.add(mapManager.northButton);
		compassPanel.add(empty);
		compassPanel.add(mapManager.westButton);
		compassPanel.add(empty2);
		compassPanel.add(mapManager.eastButton);
		compassPanel.add(empty3);
		compassPanel.add(mapManager.southButton);
		compassPanel.add(empty4);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
			if (buttonPressed == mapButton) {
				if (currentState == mapState) {
					this.hideMap();
					this.ShowStory();
					currentState = storyState;
				}
				else if (currentState == storyState) {
					this.hideStory();
					this.ShowMap();
					currentState=mapState;
				}
			}
		
	}

	public void ShowMap() {
		storyArea.setVisible(false);
		deathCount.setVisible(false);
		scroll.setVisible(false);
		map.setVisible(true);
		mapPanel.setVisible(true);
		mapManager.eastButton.setVisible(true);
		mapManager.northButton.setVisible(true);
		mapManager.southButton.setVisible(true);
		mapManager.westButton.setVisible(true);
		compassPanel.setVisible(true);
	}


	public void ShowStory() {
		storyArea.setVisible(true);
		deathCount.setVisible(true);
		scroll.setVisible(true);
	}

	public void hideMap() {
		this.setBackground(Color.WHITE);
		map.setVisible(false);
		mapPanel.setVisible(false);
		mapManager.eastButton.setVisible(false);
		mapManager.northButton.setVisible(false);
		mapManager.southButton.setVisible(false);
		mapManager.westButton.setVisible(false);
		compassPanel.setVisible(false);
	}

	public void hideStory() {
		storyArea.setVisible(false);
		deathCount.setVisible(false);
		scroll.setVisible(false);

	}

}
