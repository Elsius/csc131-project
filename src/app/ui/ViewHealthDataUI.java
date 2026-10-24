package ui;

import java.awt.*;
import javax.swing.*;
import exercise.Exercise;
import user.Patient;

public class ViewHealthRecordUI{
   public ViewHealthRecordUI(){

      JFrame frame = new JFrame("Health Record");
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      //Sample Data
      Patient patient = new Patient("user1", "password123");

      patient.setName("User1");
      patient.setHeight(65.0f);
      patient.setWeight(125.0f);

      Exercise exercise = new Exercise("Push Ups", 10.0, 0);
      exercise.setReps(20);

      //Display
      JLabel patientTitle = new JLabel("PATIENT INFORMATION");
      JLabel nameLabel = new JLabel("Name: " + patient.getName());
      JLabel heightLabel = new JLabel("Height: " + patient.getHeight());
      JLabel weightLabel = new JLabel("Weight: " + patient.getWeight());
      JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
      JLabel exerciseTitle = new JLabel("EXERCISE INFORMATION");
      JLabel exerciseNameLabel = new JLabel("Exercise: "
											+ exercise.getExerciseName());
      JLabel repsLabel = new JLabel("Reps: " + exercise.getReps());
      JLabel durationLabel = new JLabel("Duration: " + exercise.getDuration());
      JLabel exerciseWeightLabel = new JLabel("Weight Used: "
											  + exercise.getUserWeight());
      
      //Panel Settings
      panel.add(patientTitle);
      panel.add(nameLabel);
      panel.add(heightLabel);
      panel.add(weightLabel);

      panel.add(separator);

      panel.add(exerciseTitle);     
      panel.add(exerciseNameLabel);
      panel.add(repsLabel);
      panel.add(durationLabel);
      panel.add(exerciseWeightLabel);

     //Center Everything
      patientTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      heightLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      weightLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      exerciseTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      exerciseNameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      repsLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      durationLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      exerciseWeightLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

     //Frame Settings
      frame.add(panel);
      frame.setSize(500, 300);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setVisible(true);   
   }
}
