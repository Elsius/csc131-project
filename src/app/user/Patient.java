package user;

public class Patient extends User{
    private String name;
    private float height;
    private float weight;
    
    public Patient(String username, String password){
        super(username,password);
    }
    
    public void retrievePatientInfo(){
        // get info from backend and set name, height, weight
    }
    
    public void viewAccountInfo(){
        // update the gui with the patient info
        // maybe call retrievePatientInfo if info is still uninitialized
    }
    
    
}
