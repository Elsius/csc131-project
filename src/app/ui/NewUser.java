/*
 * NewUser
 * This is the window that allows adding new users to the application.
 * Last updated: 11/27/2026
 * Authors: kcompsci9, TyDiCicco, xalisha
 */
package ui;

import java.awt.*;
import javax.swing.*;
import databasehandler.databaseHandler;

public class NewUser {
    public NewUser(){
        JFrame frame = new JFrame("Health Data Application Login");
        JLabel userlabel = new JLabel("Create Username:");
        JLabel passlabel = new JLabel("Create Password:");
        JTextField usertext = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton button = new JButton("Create New User");
		JButton backButton = new JButton("Back");
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 50));

        panel.add(userlabel);
        panel.add(usertext);
        panel.add(passlabel);
        panel.add(passwordField);
        panel.add(button);
		panel.add(backButton);

		//Back button brings you back to login page
		backButton.addActionListener(e -> {
    	frame.dispose();
    	new ui.LoginUI();
		});

        //Create new user button
        button.addActionListener(e -> {
            String username = usertext.getText().trim();
			String password = String.valueOf(passwordField.getPassword());

			//Checks the input
			if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a username and password.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (databaseHandler.userExists(username)) {
                JOptionPane.showMessageDialog(frame, "That username is already taken.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create User info from Input
            user.User newUser = new user.User(username, password);

			// Send to Database
			boolean addingUserSuccess = databaseHandler.addUser(username, password);
			if (!addingUserSuccess) {
				JOptionPane.showMessageDialog(frame, "Failed to add the new user.",
											  "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
            //Swap back to Login Window
			JOptionPane.showMessageDialog(frame, "User created! Please log in.");
            frame.dispose();
            new ui.LoginUI();
        });

        // Frame Settings
		// Add panel to frame.
		frame.add(panel); 

		frame.setSize(500, 300);

		// Clicking the close button here will exit the entire application.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Page pops up in the center of the screen.
		frame.setLocationRelativeTo(null);

		frame.setResizable(false);
		frame.setVisible(true);
    }
}
