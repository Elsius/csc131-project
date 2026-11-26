/*
* databaseHandler
* handles connection to database
* Last updated: 11/26/2026
* Authors: Elsius, kcompsci9, TyDiCicco, xalisha
* Update 11/15/2026: Establishes a connection to given URL/USER/PASSWORD
* Update 11/26/2026: Creates tables, checks login, saves and reads patient info
*/
package databasehandler;

import java.sql.*;
import java.util.*;
import user.Patient;

public class databaseHandler {
    // user and pw are hardcoded here,
    // communication to db should be part of a backend service to separate from
    // frontend
    // path to database here, use a URL for a remote database
    private static final String URL = "jdbc:sqlite:app.db";
    private static final String USER = "";
    private static final String PASSWORD = "";

    // attempts to connect to database
	/**
	 * @return A java.sql.Connection. 
	 * @throws java.sql.SQLException A Java SQL exception object.
	 */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
	
	//Creates the users and exercise tables when the program first runs.
	public static void createTables() {
		//creates the users table with one row per user
        String usersTable = "CREATE TABLE IF NOT EXISTS users ("
                + "Username TEXT PRIMARY KEY, Password TEXT NOT NULL, "
                + "Name TEXT, Height REAL, Weight REAL)";
		
		//creates exercise table with one row per exercise entry
        String exerciseTable = "CREATE TABLE IF NOT EXISTS Exercise ("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT, Username TEXT NOT NULL, "
                + "name TEXT, reps INTEGER, duration REAL, weight INTEGER, date INTEGER)";
		
		//Connect to database
        try (
                Connection dbConnection = connect();
                Statement placeholder = dbConnection.createStatement()
        ) {
            placeholder.execute(usersTable);
            placeholder.execute(exerciseTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Receives a username from LoginUI and NewUser
    // Returns true if that username is already in the users table.
    public static boolean userExists(String username) {
        //Looks for a row with this username
        String query = "SELECT 1 FROM users WHERE Username = ?";

        //Connects to database
        try (
                Connection dbConnection = connect();
                PreparedStatement placeholder =
                        dbConnection.prepareStatement(query)
        ) {
            placeholder.setString(1, username);
            ResultSet result = placeholder.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Receives strings for username and password from LoginUI
    // Returns true if the password matches the one saved for that username.
    public static boolean checkPassword(String username, String password) {
        //Gets the saved password for this username
        String query = "SELECT Password FROM users WHERE Username = ?";

        //Connects to database
        try (
                Connection dbConnection = connect();
                PreparedStatement placeholder =
                        dbConnection.prepareStatement(query)
        ) {
			placeholder.setString(1, username);
            ResultSet result = placeholder.executeQuery();
            return result.next() && result.getString("Password").equals(password);
			} catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	/**
	 * Receives strings for username and password from NewUser.
	 * @return true if the user was added or false if there was an exception.
	 */
    public static boolean addUser(String username, String password) {

        //Inserts new row into the SQL users table
        String query = "INSERT INTO users (Username, Password) VALUES (?, ?)";

        //Connects to database
        try (
                Connection dbConnection = connect();
                PreparedStatement placeholder =
                        dbConnection.prepareStatement(query)
        ) {
            //Sets up table with specific data
            placeholder.setString(1, username);
            placeholder.setString(2, password);

            placeholder.executeUpdate();
			return true;
        } catch (SQLException e) {
            e.printStackTrace();
			return false;
        }
    }

	// Receives name, height and weight from AddHealthUI and saves them on the row for that username
    public static void savePatientInfo(String username, String name, float height, float weight) {
        //Updates the existing row in the SQL users table
        String query = "UPDATE users SET Name = ?, Height = ?, Weight = ? "
                + "WHERE Username = ?";

        //Connects to database
        try (
                Connection dbConnection = connect();
                PreparedStatement placeholder =
                        dbConnection.prepareStatement(query)
        ) {
            //Sets up table with specific data
            placeholder.setString(1, name);
            placeholder.setFloat(2, height);
            placeholder.setFloat(3, weight);
            placeholder.setString(4, username);

            placeholder.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Receives a username from ViewHealthDataUI
    // Returns a Patient with name, height and weight or null if the user has not saved any info yet
    public static Patient getPatient(String username) {

        //Gets the patient info for this username
        String query = "SELECT Password, Name, Height, Weight FROM users "
                + "WHERE Username = ?";

        //Connects to database
        try (
                Connection dbConnection = connect();
                PreparedStatement placeholder =
                        dbConnection.prepareStatement(query)
        ) {
            placeholder.setString(1, username);
            ResultSet result = placeholder.executeQuery();

            //Name is empty until the user adds a health record
            if (result.next() && result.getString("Name") != null) {
                Patient patient = new Patient(username, result.getString("Password"));
                patient.setName(result.getString("Name"));
                patient.setHeight(result.getFloat("Height"));
                patient.setWeight(result.getFloat("Weight"));
                return patient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
