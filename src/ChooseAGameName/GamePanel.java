package ChooseAGameName;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GamePanel extends JPanel implements ActionListener {

	// graphics and layout for each page ( game page, and map); maybe handle mouse clicks(for map)
	
	//JTextArea storyArea = new JTextArea("hey", 1, 1);
	JTextArea storyArea = new JTextArea(">Hello, how are you doing today?!\n\n\n\n\n\n\n\nsome text\n\n\n\n\n\n\n\n even more text", 20,30);
	JLabel deathCount = new JLabel("Deaths: put num later");
	JScrollPane scroll = new JScrollPane(storyArea);
	JButton mapButton = new JButton();
	JLabel map = new JLabel("You're in the map");
	int storyState = 1;
	int mapState = 2;
	int currentState = storyState;

	
	

	public void GamePage() {
		// panel= new GridLayout(3,1);
		storyArea.setEditable(false);
		this.add(scroll);
		this.add(deathCount);
		storyArea.setLineWrap(true);
		storyArea.setWrapStyleWord(true);
		scroll.setBorder(null);
		this.add(mapButton);
		mapButton.setText("Map");
		mapButton.addActionListener(this);

	}
	

	public void Map() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == mapButton){
			//this.ShowMap();			
			if(currentState == mapState ){
				this.HideMap();
				this.ShowStory();
			}
			if(currentState == storyState){
				this.HideStory();
				this.ShowMap();
			}
		}
	}

	public void ShowMap(){
		
		storyArea.setVisible(false);
		deathCount.setVisible(false);
		scroll.setVisible(false);
		this.add(map);
		currentState = mapState;
	}
	
	public void ShowStory(){
		storyArea.setVisible(true);
		deathCount.setVisible(true);
		scroll.setVisible(true);	
		currentState = storyState;
	}
	
	public void HideMap(){
		map.setVisible(false);
	}
	
	public void HideStory (){
		storyArea.setVisible(false);
		deathCount.setVisible(false);
		scroll.setVisible(false);	

	}
	
	
}
