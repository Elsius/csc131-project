package ui;

import javax.swing.*;
import java.awt.*;

public class DashboardUI{
   public DashboardUI(){

      //Creating Objects
      JFrame frame = new JFrame("Health Data Dashboard");
      JLabel welcomelabel = new JLabel("Welcome to your personal health data dashboard!");
      JButton addRecordButton = new JButton("Add Health Record");
      JButton viewRecordButton = new JButton("View Health Record");
      JButton profileButton = new JButton("Profile");
      JButton logoutButton = new JButton("Logout");
      JPanel panel = new JPanel();

		// The logout button will exit the application.
		logoutButton.addActionListener(e -> {
			System.exit(0);
		});

      //Panel Settings
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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

      //Frame Settings
      frame.add(panel);
      frame.setSize(500, 300);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

   }
}
