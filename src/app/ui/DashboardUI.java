/*
 * DashboardUI
 *
 * Last updated: 11/26/2026
 *
 * Authors: kcompsci9, xalisha
 */
package ui;

import java.awt.*;
import javax.swing.*;
import ui.ViewHealthDataUI;

public class DashboardUI{
   public DashboardUI(String username){
	   	// Creating objects
      	JFrame frame = new JFrame("Health Data Dashboard");
      	JLabel welcomelabel = new JLabel("Welcome to your personal health data dashboard!");
      	JButton addRecordButton = new JButton("Add Health Record");
      	JButton viewRecordButton = new JButton("View Health Record");
      	JButton profileButton = new JButton("Profile");
      	JButton logoutButton = new JButton("Logout");
	   	JLabel usernameLabel = new JLabel(username);
      	JPanel panel = new JPanel();

	   	//Profile button will show account username you're logged in as
	   	profileButton.addActionListener(e -> {
			JOptionPane.showMessageDialog(frame, "Logged in as: " + username, "Profile", JOptionPane.INFORMATION_MESSAGE);
	   	});

	   	//add health data button will open add health data ui
	   	addRecordButton.addActionListener(e -> {
            frame.dispose();
            new AddHealthUI(username);
        });
	   
	   	// The logout button will return to login screen
		logoutButton.addActionListener(e -> {
			frame.dispose();
			new LoginUI();
		});

		// View record button opens health records UI.
		viewRecordButton.addActionListener(e -> {
			frame.dispose();
			new ViewHealthDataUI(username);
		});

    	//Panel Settings
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	   	panel.add(usernameLabel);
      	panel.add(welcomelabel);
	   	panel.add(addRecordButton);
      	panel.add(viewRecordButton);
      	panel.add(profileButton);
      	panel.add(logoutButton);

      	//Center Everything
      	welcomelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      	addRecordButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      	viewRecordButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      	profileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      	logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	   	usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      	//Frame Settings
      	frame.add(panel);
      	frame.setSize(500, 300);
      	frame.setLocationRelativeTo(null);
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setVisible(true);
   }
}
