package exercise;

public class Exercise {
    private String name;
    private int reps;
    private double duration;
    private int weight;
    // date attribute here
    
    // constructor, getter, setter


    public void setName(String name) {
        this.name = name;
    }
    public void setReps(int reps){
        this.reps = reps;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }
    public int getReps() {
        return reps;
    }
    public double getDuration() {
        return duration;
    }
    public int getWeight() {
        return weight;
    }
}
