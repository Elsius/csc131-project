/*
 * NewUser
 * This is the window that allows adding new users to the application.
 * 11/15/2026
 * Authors: kcompsci9, TyDiCicco
 */
package ui;

import java.awt.*;
import javax.swing.*;

public class NewUser {
    public NewUser(){
        JFrame frame = new JFrame("Health Data Application Login");
        JLabel userlabel = new JLabel("Create Username:");
        JLabel passlabel = new JLabel("Create Password:");
        JTextField usertext = new JTextField(15);
        JPasswordField passtext = new JPasswordField(15);
        JButton button = new JButton("Create New User");
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 50));

        panel.add(userlabel);
        panel.add(usertext);
        panel.add(passlabel);
        panel.add(passtext);
        panel.add(button);

        //Create new user button
        button.addActionListener(e -> {
            String username = usertext.getText();
            String password = passtext.getText();

            // Create User info from Input
            user.User newUser = new user.User(username, password);

            //Swap back to Login Window
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
