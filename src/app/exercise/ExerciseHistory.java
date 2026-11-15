/*
* ExerciseHistory
* Holds a list of exercises for a particular date for the front end to display
* Last updated: 11/15/2026
* Authors: Elsius
* 11/15/2026 update: getHistory function implementation. Fetches and processes into "exercises" list
*/

package exercise;

import databaseHandler.databaseHandler;
import java.sql.*;
import java.util.*;

public class ExerciseHistory {
    private int year;
    private int month;
    private List<Exercise> exercises = new ArrayList<>(); // a list of exercises

    public void sortByDate() {
        // sorts the exercise date of each item
    }

    public void sortByName() {
        // sorts exercise list by name of each item
    }

    // pull info from backend to populate Exercise list
    // maybe determine ExerciseListID from year/month/user id?
    public void getHistory(int ExerciseListID) {

        // attempt to connect to db and prepare sql
        String query = "SELECT * FROM Exercise WHERE ExerciseListID = ? AND year = ? AND month = ?";
        try (
                Connection dbConnection = databaseHandler.connect();
                PreparedStatement pstatement = dbConnection.prepareStatement(query);) {
            pstatement.setInt(1, ExerciseListID);
            pstatement.setInt(2, this.year);
            pstatement.setInt(3, this.month);

            // attempt to query
            try (ResultSet result = pstatement.executeQuery()) {
                // if query successful, update exercise list
                exercises = new ArrayList<>();

                // loops through results, constructs an Exercise object, adds to "exercises"
                // list
                while (result.next()) {
                    String rName = result.getString("Name");
                    double rDuration = Double.parseDouble(result.getString("Duration"));
                    int rWeight = 0; // placeholder for weight
                    Exercise newEntry = new Exercise(rName, rDuration, rWeight);
                    exercises.add(newEntry);
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to communicate with database");
        }
    }

}
