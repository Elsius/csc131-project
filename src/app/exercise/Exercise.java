package exercise;

public class Exercise {
    private String exerciseName;
    private int reps;
    private double duration;
    private int userWeight;
    // date attribute here
    
    // constructor, getter, setter
	public Exercise(String name, double duration, int userWeight) {
		this.setDuration(duration);
		this.setExerciseName(name);
		this.setUserWeight(userWeight);
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
}
