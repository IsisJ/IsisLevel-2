package org.jointheleague;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {

	JButton addGuestButton = new JButton();
	JButton viewGuestButton = new JButton();
	ArrayList<String> guestNames = new ArrayList<String>();
	String guestName;

	public void createUI() {
		JFrame frame = new JFrame("Guest Book");
		JPanel panel = new JPanel();

		frame.setVisible(true);
		frame.add(panel);
		panel.add(addGuestButton);
		panel.add(viewGuestButton);
		viewGuestButton.setText("View Guests");
		addGuestButton.setText("Add Guest");
		addGuestButton.addActionListener(this);
		viewGuestButton.addActionListener(this);
		frame.pack();

	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		if (addGuestButton == buttonClicked) {
			String guestName = JOptionPane.showInputDialog(null, "Guest Name:");
			guestNames.add(guestName);
		}
		if (viewGuestButton == buttonClicked) {
			JOptionPane.showMessageDialog(null,this.buildDidsplayString(guestNames) );

		}

	}

	public String buildDidsplayString(ArrayList<String> list) {
		String JOPString = "";

		for (int i = 0; i < guestNames.size(); i++) {
			 JOPString = JOPString +  "\n"+" Guest " + (i+1) + ": " + guestNames.get(i);
		}
		return JOPString;
	}

	public static void main(String[] args) {

		GuestBook guestBook = new GuestBook();
		guestBook.createUI();
	}
}
