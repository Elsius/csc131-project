/*
 * User
 * A class for a user of the application.
 * Last updated: 11/15/2026
 * Authors: Elsius, kcompsci9, xalisha
 */
package user;

public class User {
    private String username;
    private String password;

	/**
	 * @param username The username of the user.
	 * @param password The password of the user.
	 */
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	//returns the username of the user to other classes
	public String getUsername(){
		return username;
	}
    
    // send username and password to authentication
    public void login(){
    
        
    }
}
