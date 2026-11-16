/*
* ExerciseHistory
* Holds a list of exercises for a particular date for the front end to display
* Last updated: 11/15/2026
* Authors: Elsius, kcompsci9
* 11/15/2026 update: getHistory function implementation. Fetches and processes into "exercises" list
*/

package exercise;

import databasehandler.databaseHandler;
import java.sql.*;
import java.util.*;

public class ExerciseHistory {
    private long year;
    private int month;
    private List<Exercise> exercises = new ArrayList<>(); // a list of exercises

    public void sortByDate() {
        // sorts the exercise date of each item
        exercises.sort((a,b) -> Integer.compare(a.getDate(),b.getDate()));
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
                Connection databaseConnection = databaseHandler.connect();
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);) {
            preparedStatement.setInt(1, ExerciseListID);
            preparedStatement.setLong(2, this.year);
            preparedStatement.setInt(3, this.month);

            // attempt to query
            try (ResultSet result = preparedStatement.executeQuery()) {
                // if query successful, update exercise list
                exercises = new ArrayList<>();

                // loops through results, constructs an Exercise object, adds to "exercises"
                // list
                while (result.next()) {
                    String resultName = result.getString("Name");
                    double resultDuration = result.getDouble("Duration");
                    int resultWeight = 0; // placeholder for weight
                    int resultDate = result.getInt("Date");
                    Exercise newEntry = new Exercise(resultName, resultDuration, resultWeight, resultDate);
                    exercises.add(newEntry);
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to communicate with database");
        }
    }

}
