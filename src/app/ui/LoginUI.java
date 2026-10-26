package ui;

import java.awt.*;
import javax.swing.*;
import ui.DashboardUI;
import ui.NewUser;

public class LoginUI{
   public LoginUI(){

      //Creating Objects
      JFrame frame = new JFrame("Health Data Application Login");
      JLabel userlabel = new JLabel("Username:");
      JLabel passlabel = new JLabel("Password:");
      JTextField usertext = new JTextField(15);
      JTextField passtext = new JTextField(15);
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

      //Frame Settings
      frame.add(panel); //Add panel to frame
      frame.setSize(500, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit button
      frame.setLocationRelativeTo(null); //Page pops up center of screen
      frame.setResizable(false);
      frame.setVisible(true);

   }
}
