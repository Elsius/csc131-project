/*
* ExerciseHistory
* Holds a list of exercises for a particular date for the front end to display
* Last updated: 11/15/2026
* Authors: Elsius, kcompsci9, xalisha
* 11/15/2026 update: getHistory function implementation. Fetches and processes into "exercises" list
* 11/26/2026 update: switched ExerciseListID to username, implemented sortByName, removed year and month
*/

package exercise;

import databasehandler.databaseHandler;
import java.sql.*;
import java.util.*;

public class ExerciseHistory {
    private List<Exercise> exercises = new ArrayList<>(); // a list of exercises

    public void sortByDate() {
        // sorts the exercise date of each item
        exercises.sort((a,b) -> Integer.compare(a.getDate(),b.getDate()));
    }

    public void sortByName() {
        // sorts exercise list by name of each item
        exercises.sort((a,b) -> a.getExerciseName().compareToIgnoreCase(b.getExerciseName()));
    }
    public List<Exercise> getHistory(){
        return exercises;
    }
    // pull info from backend to populate Exercise list
    // maybe determine ExerciseListID from year/month/user id?
    public void updateHistory(String username) {

        // attempt to connect to db and prepare sql
        String query = "SELECT ID, name, reps, duration, weight, date FROM Exercise " + "WHERE Username = ? ORDER BY date DESC, ID DESC";
        try (
                Connection databaseConnection = databaseHandler.connect();
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);) {
            preparedStatement.setString(1, username);

            // attempt to query
            try (ResultSet result = preparedStatement.executeQuery()) {
                // if query successful, update exercise list
                exercises = new ArrayList<>();

                // loops through results, constructs an Exercise object, adds to "exercises"
                // list
                while (result.next()) {
                    String resultName = result.getString("Name");
                    double resultDuration = result.getDouble("Duration");
                    int resultWeight = result.getInt("Weight");
                    int resultDate = result.getInt("Date");
                    Exercise newEntry = new Exercise(resultName, resultDuration, resultWeight, resultDate);
                    newEntry.setReps(result.getInt("Reps"));
                    newEntry.setId(result.getInt("ID"));
                    exercises.add(newEntry);
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to communicate with database");
            e.printStackTrace();
        }
    }
}
