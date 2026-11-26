/*
 * Exercise
 *
 * 2026-11-05
 *
 * Authors: Elsius, kcompsci9, xalisha
 */
package exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import databasehandler.databaseHandler;

public class Exercise {
    private String exerciseName;
    private int reps;
    private double duration;
    private int userWeight;
    private int date; // YYYYMMDD format.
    
    // constructor, getter, setter
	public Exercise(String name, double duration, int userWeight) {
		this.setDuration(duration);
		this.setExerciseName(name);
		this.setUserWeight(userWeight);
	}
    // constructor with date included
    public Exercise(String name, double duration, int userWeight,int date) {
		this.setDuration(duration);
		this.setExerciseName(name);
		this.setUserWeight(userWeight);
        this.setDate(date);
	}
    public void setExerciseName(String name) {
        this.exerciseName = name;
    }
    public void setReps(int reps){
        this.reps = reps;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public void setUserWeight(int weight) {
        this.userWeight = weight;
    }
    public void setDate(int date){
        this.date = date;
    }
    public String getExerciseName() {
        return this.exerciseName;
    }
    public int getReps() {
        return this.reps;
    }
    public double getDuration() {
        return this.duration;
    }
    public int getUserWeight() {
        return this.userWeight;
    }
    public int getDate(){
        return this.date;
    }

    // saves instance of Exercise to Exercise table in database.
    public void saveToDatabase(String username){
        System.out.println("Attempting to save to database");
        String query = "INSERT INTO Exercise (Username, name, reps, duration, weight, date) VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection dbConnection = databaseHandler.connect();
            PreparedStatement statement = dbConnection.prepareStatement(query);
        ){
            statement.setString(1, username);
			statement.setString(2, this.exerciseName);
			statement.setInt(3, this.reps);
            statement.setDouble(4, this.duration);
            statement.setInt(5, this.userWeight);
            statement.setInt(6, this.date);
            statement.executeUpdate();

        }catch(SQLException e){
            System.out.println("Failed to save to database");
			e.printStackTrace();
        }
    }
}
