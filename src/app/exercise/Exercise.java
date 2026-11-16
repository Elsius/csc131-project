/*
 * Exercise
 *
 * 2026-11-05
 *
 * Authors: Elsius, kcompsci9
 */
package exercise;

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
}
