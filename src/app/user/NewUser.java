package ui;

import javax.swing.*;
import java.awt.*;



public class NewUser {
    public NewUser(){
        JFrame frame = new JFrame("Health Data Application Login");
        JLabel userlabel = new JLabel("Create Username:");
        JLabel passlabel = new JLabel("Create Password:");
        JTextField usertext = new JTextField(15);
        JTextField passtext = new JTextField(15);
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


        //Frame Settings
        frame.add(panel); //Add panel to frame
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit button
        frame.setLocationRelativeTo(null); //Page pops up center of screen
        frame.setResizable(false);
        frame.setVisible(true);


    }



}
