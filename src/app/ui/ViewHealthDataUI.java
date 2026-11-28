/*
 * ViewHealthDataUI
 *
 * Last Update: 11/27/2026
 *
 * Authors: kcompsci9, xalisha
 */
package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import exercise.Exercise;
import user.Patient;
import databasehandler.databaseHandler;
import exercise.ExerciseHistory;

public class ViewHealthDataUI{
   public ViewHealthDataUI(String username){
	   Patient patient = databaseHandler.getPatient(username);
	   ExerciseHistory exerciseHistory = new ExerciseHistory();
	   exerciseHistory.updateHistory(username);
	   List<Exercise> history = exerciseHistory.getHistory();

	   //If no health data yet, show error and go back to dashboard
		if (patient == null && history.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Data error: no health data found. Please add a health record first.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            new DashboardUI(username);
            return;
        }

      	JFrame frame = new JFrame("Health Record");
      	JPanel panel = new JPanel();
      	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	   
      	//Display
      	JLabel patientTitle = new JLabel("PATIENT INFORMATION");
      	JLabel nameLabel = new JLabel("Name: " + (patient == null ? "N/A" : patient.getName()));
      	JLabel heightLabel = new JLabel("Height (inches): " + (patient == null ? "N/A" : patient.getHeight()));
      	JLabel weightLabel = new JLabel("Weight (lbs): " + (patient == null ? "N/A" : patient.getWeight()));
      	JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
      	JLabel exerciseTitle = new JLabel("EXERCISE INFORMATION");
      
      	//Panel Settings
      	panel.add(patientTitle);
      	panel.add(nameLabel);
      	panel.add(heightLabel);
      	panel.add(weightLabel);
		panel.add(Box.createVerticalStrut(10));

      	panel.add(separator);

      	panel.add(exerciseTitle);

     	//Center Everything
      	patientTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      	nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      	heightLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      	weightLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      	exerciseTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);

	   	//Exercise table
	   	String[] columns = {"Date", "Exercise Name", "Reps", "Duration (minutes)", "Weight Used (lbs)"};
      	DefaultTableModel model = new DefaultTableModel(columns, 0);
      	for (Exercise ex : history) {
         	model.addRow(new Object[]{ex.getDate(), ex.getExerciseName(), ex.getReps(), ex.getDuration(), ex.getUserWeight()});
      	}
      	JTable table = new JTable(model);
      	table.setEnabled(false); // read-only

      	//Back button returns to the dashboard
      	JButton backButton = new JButton("Back");
      	backButton.addActionListener(e -> {
         	frame.dispose();
         	new DashboardUI(username);
      });

		// Frame settings for back button, closing button, layout
	   	frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.NORTH);
	   	frame.add(new JScrollPane(table), BorderLayout.CENTER);
	   	frame.add(backButton, BorderLayout.SOUTH);
		frame.setSize(550, 400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
   }
}
