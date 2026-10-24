package user;

public class Patient extends User{
    private String name;
    private float height;
    private float weight;
    
    public Patient(String username, String password){
        super(username,password);
    }
    
    public void setName(String input){
        name = input;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public String getName(){
        return name;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public void retrievePatientInfo(){
        // get info from backend and set name, height, weight
    }
    
    public void viewAccountInfo(){
        // update the gui with the patient info
        // maybe call retrievePatientInfo if info is still uninitialized
    }
    
    
}
