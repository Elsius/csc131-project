/*
 * LoginUI
 * This is the first window that appears when the user runs the application.
 * The user authenticates here to access the rest of the application.
 * 11/15/2026
 * Authors: kcompsci9, TyDiCicco, xalisha
 */
package ui;

import java.awt.*;
import javax.swing.*;
import ui.DashboardUI;
import ui.NewUser;

public class LoginUI{
   public LoginUI(){

		// Creating objects
		JFrame frame = new JFrame("Health Data Application Login");
		JLabel userlabel = new JLabel("Username:");
		JLabel passlabel = new JLabel("Password:");
		JTextField usertext = new JTextField(15);
		JPasswordField passtext = new JPasswordField(15);
		JButton button = new JButton("Login");
		JButton button2 = new JButton("Create New User");
		JPanel panel = new JPanel();

      //Log in Button Function
      button.addActionListener(e -> {
         frame.dispose();
         new DashboardUI();
      });

      //Create New User Function
      button2.addActionListener(e -> {
         frame.dispose();
         new NewUser();
      });

      //Panel Settings
      panel.add(userlabel);
      panel.add(usertext);
      panel.add(passlabel);
      panel.add(passtext);
      panel.add(button);
      panel.add(button2);

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
